package com.kkhjl.cloud.member.api;

import com.kkhjl.cloud.member.bo.MemberInfo;
import com.kkhjl.cloud.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberSearchApi")
public class MemberSearchApiImpl implements MemberSearchApi {
    @Autowired
    private MemberDao memberDao;
    @Override
    public MemberInfo getMemberInfo(String id) {
        return  memberDao.selectMemberById(id);
    }
}
