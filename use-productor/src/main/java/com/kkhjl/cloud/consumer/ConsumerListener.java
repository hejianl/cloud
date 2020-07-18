package com.kkhjl.cloud.consumer;

import com.kkhjl.cloud.member.bo.MemberInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
public class ConsumerListener {
    Logger log = LoggerFactory.getLogger(ConsumerListener.class);
    //@KafkaListener(topics = "test")
    public void onMessage(MemberInfo m){

        log.info(m.getAddress());
    }
}
