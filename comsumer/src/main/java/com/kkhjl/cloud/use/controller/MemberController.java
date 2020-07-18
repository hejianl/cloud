package com.kkhjl.cloud.use.controller;

import com.kkhjl.cloud.member.bo.MemberInfo;
import com.kkhjl.cloud.use.service.MemberRemoteService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MemberController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MemberRemoteService memberRemoteService;
    @HystrixCommand(commandKey = "getMemberById",groupKey = "member")
   @GetMapping(value="/get/{id}")
    public MemberInfo getUserInfo(@PathVariable("id") String id){
        return memberRemoteService.selectMemberById(id,20);
    }
}
