package com.kkhjl.cloud.member.api;

import com.kkhjl.cloud.member.bo.MemberInfo;

import java.util.List;

public interface MemberHandleApi {
    int batchCreateMember(List<MemberInfo> info);
}
