package ru.kashtanov.order_service.dto;

import ru.kashtanov.order_service.model.Product;

import java.util.List;
import java.util.Objects;

public class OrderRequestDto {
    private String orderNumber;
    private String ownerName;
    private List<Product> productListList;

    public OrderRequestDto() {
    }

    public OrderRequestDto(String ownerName, List<Product> productListList,String orderNumber) {
        this.ownerName = ownerName;
        this.productListList = productListList;
        this.orderNumber = orderNumber;
    }

    public OrderRequestDto(String orderNumber, String ownerName) {
        this.orderNumber = orderNumber;
        this.ownerName = ownerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Product> getProductListList() {
        return productListList;
    }

    public void setProductListList(List<Product> productListList) {
        this.productListList = productListList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequestDto that = (OrderRequestDto) o;
        return Objects.equals(ownerName, that.ownerName) && Objects.equals(productListList, that.productListList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerName, productListList);
    }

    @Override
    public String toString() {
        return "OrderRequestDto{" +
                "ownerName='" + ownerName + '\'' +
                ", productListList=" + productListList +
                '}';
    }
}
