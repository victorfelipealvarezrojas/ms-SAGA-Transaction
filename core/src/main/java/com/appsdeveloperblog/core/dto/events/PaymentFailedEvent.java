package com.appsdeveloperblog.core.dto.events;

import java.util.UUID;

public class PaymentFailedEvent {
    private UUID orderId;
    private UUID productId;
    private Integer quantity;

    public PaymentFailedEvent() {
    }

    public PaymentFailedEvent(UUID orderId, UUID productId, Integer quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}