package com.appsdeveloperblog.core.dto.commands;

import java.util.UUID;

public class ReserveProductCommand {
    private UUID productId;
    private int quantity;
    private UUID orderId;

    public ReserveProductCommand() {
    }

    public ReserveProductCommand(UUID productId, int quantity, UUID orderId) {
        this.productId = productId;
        this.quantity = quantity;
        this.orderId = orderId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
