package com.babymonitor.scenario.service;

import com.babymonitor.scenario.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;


@Service
@ConditionalOnExpression("!'${spring.rabbitmq.host}'.isEmpty()")
public class RabbitMQListenerService {

//    @RabbitListener(bindings = @QueueBinding(
//            value = @org.springframework.amqp.rabbit.annotation.Queue(value = RabbitMQConfig.MATLAB_QUEUE, durable = "true"),
//            exchange = @Exchange(value = RabbitMQConfig.TOPIC_EXCHANGE_NAME, type = "topic"),
//            key = "matlab.simulationUpdated" // Specific routing key for "simulation.updated"
//    ))


}
