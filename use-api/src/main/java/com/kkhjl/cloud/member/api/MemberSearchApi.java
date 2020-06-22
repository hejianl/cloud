package com.kkhjl.cloud.member.api;

import com.kkhjl.cloud.member.bo.MemberInfo;

public interface MemberSearchApi {
    MemberInfo getMemberInfo(String userId);
}
