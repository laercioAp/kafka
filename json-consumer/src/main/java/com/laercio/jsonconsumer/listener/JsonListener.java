package com.laercio.jsonconsumer.listener;

import com.laercio.jsonconsumer.model.Payment;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JsonListener {

    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) throws InterruptedException {
        log.info("Recebi o pagamento {}", payment.toString());
        Thread.sleep(2000);
        log.info("Validando fraude ...");
        Thread.sleep(2000);

        log.info("Compra aprovada ...");
        Thread.sleep(2000);
    }

    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) throws InterruptedException {
        Thread.sleep(3000);
        log.info("Gerando PDF do produto de id {} ...", payment.getId());
        Thread.sleep(3000);
    }

    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() throws InterruptedException {
        Thread.sleep(3000);
        log.info("Enviando email de confirmacao ...");
    }
}
