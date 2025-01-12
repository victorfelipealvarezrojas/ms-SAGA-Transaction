package com.appsdeveloperblog.core.dto.commands;

import java.math.BigDecimal;
import java.util.UUID;

public class ProcessPaymentCommand {
    private UUID orderId;
    private UUID productId;
    private BigDecimal price;
    private int quantity;

    public ProcessPaymentCommand() {
    }

    public ProcessPaymentCommand(UUID orderId, UUID productId, BigDecimal price, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }
}
