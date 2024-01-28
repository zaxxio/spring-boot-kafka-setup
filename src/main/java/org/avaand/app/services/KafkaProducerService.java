package org.avaand.app.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServices<K, V> {

    private final KafkaTemplate<K, V> kafkaTemplate;

    public KafkaProducerServices(KafkaTemplate<K, V> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, K key, V message) {
        kafkaTemplate.send(topic, key, message);
    }
}
