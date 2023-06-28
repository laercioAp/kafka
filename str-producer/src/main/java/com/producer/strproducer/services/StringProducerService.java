package com.producer.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        try {
            log.info("Mensagem sendo enviada {}", message);
            kafkaTemplate.send("str-topic", message);
            log.info("Mensagem enviada com suceso{}", message);
        } catch (Exception ex) {
            log.error("Error ao enviar a message ao topico", ex);
        }
    }
}
