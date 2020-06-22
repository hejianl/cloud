package com.kkhjl.cloud.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {
    Logger log = LoggerFactory.getLogger(ConsumerListener.class);
    @KafkaListener(topics = "testTopic")
    public void onMessage(String m){
        log.info(m);
    }
}
