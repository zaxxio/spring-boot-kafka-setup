package org.avaand.app.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.avaand.app.events.Location;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KafkaConsumerService {

    @Transactional
    @KafkaListener(topics = "user-location", groupId = "user-group")
    public void listen(Location location) {
        try {
            // Process the message
            System.out.println("Received Message: " + location);

            // Manually acknowledge the message after successful processing
        } catch (Exception e) {
            // Handle the exception, you may choose not to acknowledge the message here
            e.printStackTrace();
        }
    }

}
