package com.rogerserra.controller;

import com.rogerserra.config.MessageQueueConfig;
import com.rogerserra.model.Machine;
import com.rogerserra.model.OpengateOperation;
import com.rogerserra.model.OpengateRequest;
import com.rogerserra.model.OpengateResponse;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
import org.junit.Ignore;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PublisherControllerTest {

    @Value("${spring.rabbitmq.queue}")
    private String queue;
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    @Autowired
    private MessageQueueConfig config;

    @Mock
    private RabbitTemplate template;

    private OpengateRequest opengateRequest;

    @BeforeEach
    void setUp() {
        ArrayList<Machine> machines = new ArrayList<>();
        machines.add(new Machine(
                "Machine 1",
                "OK",
                15.67
        ));
        machines.add(new Machine(
                "Machine 2",
                "OK",
                34.56
        ));
        opengateRequest = new OpengateRequest(
                "1.0",
                new OpengateOperation(
                        new OpengateResponse(
                                "1",
                                "dummy",
                                "2",
                                "test",
                                machines
                        )
                )
        );
    }
    /*
    @Ignore
    @Test
    @DisplayName("Send Request to Rabbitmq Exchange")
    void canPublishRequest() {

        willDoNothing()
                .given(template).convertAndSend(opengateRequest);

        ArgumentCaptor<OpengateRequest> captor =
                ArgumentCaptor.forClass(OpengateRequest.class);
        verify(template).convertAndSend(opengateRequest);
        assertThat(captor.getValue().getVersion().equals("1.0"));
    }
    */
     
}