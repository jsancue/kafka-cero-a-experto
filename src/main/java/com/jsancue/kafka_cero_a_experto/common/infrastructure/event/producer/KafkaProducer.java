package com.jsancue.kafka_cero_a_experto.common.infrastructure.event.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, GenericRecord> kafkaTemplate;

    public void send(String topic, GenericRecord record) {
        log.info("Sending message to topic {}. Record{}", topic, record);
        String uuid = UUID.randomUUID().toString();
        CompletableFuture<SendResult<String, GenericRecord>> sendResultCompletableFuture = kafkaTemplate.send(topic, uuid, record);

        sendResultCompletableFuture.whenComplete((sendResult, throwable) -> {
            if (throwable == null) {
                log.info("Record sent to topic {}. Record {}. RecordUUID{}, Offset{}",
                        topic, record, uuid, sendResult.getRecordMetadata().offset());
            }else {
                log.info("Error sending record to topics: {}. Record{}. RecordUUID{}", topic, record, uuid, throwable);
            }
        });
    }
}
