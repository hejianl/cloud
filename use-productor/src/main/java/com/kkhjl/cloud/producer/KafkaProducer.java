package com.kkhjl.cloud.producer;

import com.kkhjl.cloud.member.bo.MemberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class  KafkaProducer {
    //@Autowired
    private KafkaTemplate<String, MemberInfo> kafkaTemplate;
    private static final String TOPIC_NAME="test";
    //发送消息方法
    public void send(MemberInfo info) {
        ListenableFuture<SendResult<String, MemberInfo>>  respon =  kafkaTemplate.send(TOPIC_NAME,info);
        try {
            System.out.println(respon.get().toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
