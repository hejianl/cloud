package com.kkhjl.cloud.member.api;

import com.kkhjl.cloud.member.bo.MemberInfo;
import com.kkhjl.cloud.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("memberHandleApi")

public class MemberHandleApiImpl implements MemberHandleApi {
    @Autowired
    private MemberDao memberDao;
    @Override
    public int batchCreateMember(List<MemberInfo> info) {
        return memberDao.batchInsert(info);
    }
}
