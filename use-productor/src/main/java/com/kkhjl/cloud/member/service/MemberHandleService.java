package com.kkhjl.cloud.member.service;

import java.util.List;
import java.util.Map;

public interface MemberHandleService {
    int batchSaveMembers(List<Map<String,Object>> members) throws Exception;
}
