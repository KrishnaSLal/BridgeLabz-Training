package com.fundoo.export.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fundoo.export.config.RabbitMQConfig;
import com.fundoo.export.service.ExportService;

@Component
public class ExportEventConsumer {

    private final ExportService exportService;

    public ExportEventConsumer(
            ExportService exportService) {

        this.exportService =
                exportService;
    }

    @RabbitListener(
            queues = RabbitMQConfig.EXPORT_QUEUE
    )
    public void consumeExportEvent(
            String message) {

        try {

            /*
             * Expected message format:
             *
             * userId|format
             */

            String[] parts =
                    message.split("\\|");

            if (parts.length != 2) {

                throw new IllegalArgumentException(
                        "Invalid export event"
                );
            }

            int userId =
                    Integer.parseInt(parts[0]);

            String format =
                    parts[1];

            System.out.println(
                    "Received export request. "
                    + "User: "
                    + userId
                    + ", Format: "
                    + format
            );

            exportService.exportNotes(
                    userId,
                    format
            );

        } catch (Exception e) {

            System.err.println(
                    "Failed to process export event: "
                    + e.getMessage()
            );
        }
    }
}