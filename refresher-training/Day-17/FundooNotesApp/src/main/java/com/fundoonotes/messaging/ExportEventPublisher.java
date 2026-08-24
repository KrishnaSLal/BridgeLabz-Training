package com.fundoonotes.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.fundoonotes.config.RabbitMQConfig;

@Service
public class ExportEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public ExportEventPublisher(
            RabbitTemplate rabbitTemplate) {

        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishExportRequest(
            ExportRequestEvent event) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXPORT_EXCHANGE,
                RabbitMQConfig.EXPORT_ROUTING_KEY,
                event
        );
    }
}