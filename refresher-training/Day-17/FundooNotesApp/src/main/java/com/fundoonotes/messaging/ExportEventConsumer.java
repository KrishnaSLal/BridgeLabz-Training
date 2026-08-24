package com.fundoonotes.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fundoonotes.config.RabbitMQConfig;
import com.fundoonotes.service.NoteExportService;

@Service
public class ExportEventConsumer {

    private final NoteExportService noteExportService;

    public ExportEventConsumer(
            NoteExportService noteExportService) {

        this.noteExportService = noteExportService;
    }

    @RabbitListener(
            queues = RabbitMQConfig.EXPORT_QUEUE
    )
    public void processExport(
            ExportRequestEvent event) {

        System.out.println(
                "Received export request for user: "
                + event.getUserId()
        );

        noteExportService.exportNotes(
                event.getUserId(),
                event.getFormat()
        );
    }
}