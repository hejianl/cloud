package com.kkhjl.cloud.use.service;

import com.kkhjl.cloud.member.bo.MemberInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(value = "member-productor")
public interface MemberRemoteService {
    @GetMapping(value = "/get/{id}/{size}")
    MemberInfo selectMemberById(@PathVariable("id") String id, @PathVariable("size") int size) ;
}
