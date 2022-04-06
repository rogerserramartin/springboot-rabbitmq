package com.rogerserra.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueueConfig {

    @Value("${spring.rabbitmq.queue}") // this value comes from application.yml
    public static String queue;
    @Value("${spring.rabbitmq.exchange}") // this value comes from application.yml
    public static String exchange;
    @Value("${spring.rabbitmq.routingkey}") // this value comes from application.yml
    public static String routingKey;

    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(exchange);
    }

    /**
     * This method links the exchange to the queue
     * @param queue is the message queue
     * @param topicExchange a producer never sends a message directly to a queue. Instead, it uses an exchange as a routing mediator
     * @return relationship between an exchange and a queue: This can be simply read as: the queue is interested in messages from this exchange.
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder
                .bind(queue)
                .to(topicExchange)
                .with(routingKey);
    }

    // this method converts our class to JSON format
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
