package com.example.postgresql.messagequeue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;


public class MyQueue {
    @Bean
    public Queue myQueue() {
        return new Queue("myQueue", false);
    }

    @RabbitListener(queues = "myQueue")
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);
    }
}