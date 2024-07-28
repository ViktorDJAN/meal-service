package ru.kashtanov.order_service.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String orderNumber;
    @Column
    private String ownerName;
    @ElementCollection(fetch = FetchType.EAGER)
    List<Product> list;

    public Order() {
    }

    public Order(String orderNumber, String ownerName, List<Product> list) {
        this.orderNumber = orderNumber;
        this.ownerName = ownerName;
        this.list = list;
    }

    public Order(String orderNumber, String ownerName) {
        this.orderNumber = orderNumber;
        this.ownerName = ownerName;
    }

    public Order(Long id, String orderNumber) {
        this.id = id;
        this.orderNumber = orderNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id)
                && Objects.equals(orderNumber, order.orderNumber)
                && Objects.equals(list, order.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, list);
    }
}