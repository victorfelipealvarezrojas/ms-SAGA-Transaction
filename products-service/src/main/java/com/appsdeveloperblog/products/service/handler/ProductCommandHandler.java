package com.appsdeveloperblog.products.service.handler;

import com.appsdeveloperblog.core.dto.Product;
import com.appsdeveloperblog.core.dto.commands.ReserveProductCommand;
import com.appsdeveloperblog.core.dto.events.ProductReservationFailedEvent;
import com.appsdeveloperblog.core.dto.events.ProductReservedEvent;
import com.appsdeveloperblog.products.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "${products.commands.topic.name}")
public class ProductCommandHandler {

    private final ProductService productService;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private String productEventTopicName;

    public ProductCommandHandler(
            ProductService productService,
            KafkaTemplate<String, Object> kafkaTemplate,
            @Value("${products.events.topic.name}")
            String productEventTopicName
    ) {
        this.productService = productService;
        this.kafkaTemplate = kafkaTemplate;
        this.productEventTopicName = productEventTopicName;
    }

    @KafkaHandler
    public void handle(@Payload ReserveProductCommand command) {
        try {
            Product desiredProduct = new Product(
                    command.getProductId(),
                    command.getQuantity()
            );
            Product recervedProduct = this.productService.reserve(desiredProduct, command.getOrderId());
            ProductReservedEvent event = new ProductReservedEvent(
                    command.getOrderId(),
                    recervedProduct.getId(),
                    recervedProduct.getPrice(),
                    recervedProduct.getQuantity()
            );

            kafkaTemplate.send(productEventTopicName, event);

        } catch (Exception e) {
            ProductReservationFailedEvent eventFailed = new ProductReservationFailedEvent(
                    command.getProductId(),
                    command.getOrderId(),
                    command.getQuantity()
            );
            kafkaTemplate.send(productEventTopicName, eventFailed);
        }
    }
}
