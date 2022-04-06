package com.rogerserra.controller;

import com.rogerserra.config.MessageQueueConfig;
import com.rogerserra.model.OpengateRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
public class PublisherController {

    @Autowired
    private RabbitTemplate template;

    public String publishRequest(@RequestBody OpengateRequest opengateRequest){
        template.convertAndSend(
                MessageQueueConfig.exchange,
                MessageQueueConfig.routingKey,
                opengateRequest
                );
        
        return "Request published!";
    }
}
