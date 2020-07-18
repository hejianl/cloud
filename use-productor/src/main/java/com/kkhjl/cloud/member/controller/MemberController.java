package com.kkhjl.cloud.member.controller;

import com.kkhjl.cloud.member.api.MemberHandleApi;
import com.kkhjl.cloud.member.bo.MemberInfo;
import com.kkhjl.cloud.member.dao.MemberDao;
import com.kkhjl.cloud.member.service.MemberHandleService;
import com.kkhjl.cloud.producer.KafkaProducer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class MemberController {
    private static final Log l = LogFactory.getLog(MemberController.class);
    @Autowired
    private MemberHandleService memberHandleService;
    @Autowired
    private MemberHandleApi memberHandleApi;
    @Autowired
    private  MemberDao memberDao;
    @Autowired
    private KafkaProducer kafkaProducer;
    @GetMapping(value = "/get/{id}/{size}")
    public MemberInfo selectMemberById(@PathVariable("id") String id,@PathVariable("size") int size) throws Exception{
        //memberHandleService.batchSaveMembers(null);
        MemberInfo r = new MemberInfo();
        r.setAddress("test");
        return r;
    }
    private static ExecutorService e = Executors.newFixedThreadPool(100);

    @GetMapping(value = "/start")
    public int start() throws Exception{
        CyclicBarrier c = new CyclicBarrier(50, new Runnable() {
            @Override
            public void run() {
                l.error("end ");
            }
        });

        while (true) {
            for (int y = 0; y < 50; y++) {
                e.submit(new UpdateNameByIdThread(memberDao, c));
                e.submit(new UpdateNameByIdentifyThread(memberDao, c));
            }
            Thread.sleep(100);
        }
    }
    @GetMapping(value = "/message")
    public  boolean senderMessage(@RequestParam("name") String name, @RequestParam("address") String address){
        MemberInfo m = new MemberInfo();
        m.setId(UUID.randomUUID().getLeastSignificantBits());
        m.setName(name);
        m.setAddress(address);
        kafkaProducer.send(m);
        return true;
    }
    class UpdateNameByIdThread implements  Runnable{
        private CyclicBarrier c;
        private MemberDao m;
        public UpdateNameByIdThread(MemberDao m,CyclicBarrier c){
            this.c = c;
            this.m=m;
        }
        @Override
        public void run() {
            try {
                c.await();
                l.info("开始执行 UpdateNameByIdThread");

                memberDao.sortIncrementById(234567891234568789L);
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
    class UpdateNameByIdentifyThread implements  Runnable{
        private CyclicBarrier c;
        private MemberDao m;
        public UpdateNameByIdentifyThread(MemberDao m,CyclicBarrier c){
            this.c = c;
            this.m=m;
        }
        @Override
        public void run() {
            try {
                c.await();//线程等待一起执行
                l.info("开始执行 UpdateNameByIdentifyThread");

                m.sortIncrementByIdentify(234567891234567991L);
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
}
