package org.avaand.app.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService<K, V> {

    private final KafkaTemplate<K, V> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<K, V> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, K key, V message) {
        kafkaTemplate.send(topic, key, message);
    }
}
