package ru.kashtanov.notification_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import ru.kashtanov.notification_service.event.OrderEvent;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}
    @KafkaListener(topics = "notification_topic")
	public void handleNotificationTopic( OrderEvent orderEvent){
         log.info("Received the order: " + orderEvent.getOrderNumber());
	}


}
