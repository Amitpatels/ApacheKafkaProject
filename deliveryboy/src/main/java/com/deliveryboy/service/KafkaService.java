package com.deliveryboy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.deliveryboy.constant.AppConstants.LOCATION_TOPIC_NAME;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateLocation(String location){
            this.kafkaTemplate.send(LOCATION_TOPIC_NAME,location);
            this.logger.info("message produce");
            logger.info("Message Produce from delivery boy : "+location);
            System.out.println("-----------------------------------------------------");

        return true;
    }

}
