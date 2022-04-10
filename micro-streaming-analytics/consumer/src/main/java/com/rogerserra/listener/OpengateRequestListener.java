package com.rogerserra.listener;

import com.rogerserra.config.MessageQueueConfig;
import com.rogerserra.model.OpengateRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OpengateRequestListener {

    @RabbitListener(queues = "request_queue")
    public void listener(OpengateRequest opengateRequest){
        System.out.println(opengateRequest.getVersion());
    }

}
