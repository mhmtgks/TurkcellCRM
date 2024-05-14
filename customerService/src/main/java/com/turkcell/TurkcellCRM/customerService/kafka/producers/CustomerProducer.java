package com.turkcell.TurkcellCRM.customerService.kafka.producers;

import com.turkcell.TurkcellCRM.commonPackage.CustomerCreatedEvent;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
public class CustomerProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public CustomerProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CustomerCreatedEvent customerCreatedEvent){
        LOGGER.info(String.format("Customer added =>%s",customerCreatedEvent.toString()));

        Message<CustomerCreatedEvent> message = MessageBuilder.withPayload(customerCreatedEvent)
//                .setHeader(KafkaHeaders.TOPIC,"inventory-customer-created")
                .setHeader(KafkaHeaders.TOPIC, "inventory-customer-created")
                .build();

        kafkaTemplate.send(message);

    }

//    public void sendMessage(InventoryCreatedEvent event){
//        LOGGER.info(String.format("Inventory created => %s",event.toString()));
//
//        Message<InventoryCreatedEvent> message = MessageBuilder.withPayload(event)
//                .setHeader(KafkaHeaders.TOPIC,"inventory-car-created")
//                .build();
//
//        kafkaTemplate.send(message);
//    }
}
