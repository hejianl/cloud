package com.kkhjl.cloud.use.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kkhjl.cloud.member.api.MemberSearchApi;
import com.kkhjl.cloud.member.bo.MemberInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @Reference
    private MemberSearchApi memberSearchApi;
   @GetMapping(value="/get/{id}")
    public MemberInfo getUserInfo(@PathVariable("id") String id){
       MemberInfo r= new MemberInfo();
       r.setAddress(id);

        return memberSearchApi.getMemberInfo(id);
    }
}
