package ru.kashtanov.order_service.event;

import java.util.List;

public class OrderEvent {
    private String orderNumber;

    public OrderEvent(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderEvent() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
