package com.kkhjl.cloud.member.service;

import com.kkhjl.cloud.member.bo.MemberInfo;
import com.kkhjl.cloud.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("memberHandleService")
public class MemberHandleServiceImpl implements MemberHandleService {
    @Autowired
    private MemberDao memberDao;
    @Override
    @Transactional(propagation  = Propagation.REQUIRED)
    public int batchSaveMembers(List<Map<String, Object>> members) throws Exception {
        int size = 1000;
        page(size).forEach(a ->{
            if(a > 0) {
                memberDao.batchInsert(createMemberList(a));
            }
        });

        if(size==1000){
            throw  new Exception("1111");
        }

        return 0;
    }
    private List<MemberInfo>  createMemberList(int size){
        List<MemberInfo> r = new ArrayList<>(size);
        for(int x=0;x <size;x ++){
            MemberInfo i = new MemberInfo();
            i.setId(UUID.randomUUID().getLeastSignificantBits());
            i.setName(UUID.randomUUID().toString());
            i.setAddress(UUID.randomUUID().toString());
            i.setIdentify(UUID.randomUUID().getLeastSignificantBits());
            r.add(i);


        }
        return r;
    }
    private List<Integer> page(int size){
        List<Integer> r = new ArrayList<>();
        int s = size/200;
        int d = size%200;
        for(int i =0;i<s ;i++){
            r.add(200);
        }
        r.add(d);
        return r;
    }
}
