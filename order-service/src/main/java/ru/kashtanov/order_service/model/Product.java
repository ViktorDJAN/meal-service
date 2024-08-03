package ru.kashtanov.order_service.model;

import jakarta.persistence.*;

import java.util.Objects;

@Embeddable
public class Product {

    private Long id;
    private String productName;
    private String skuCode;
    private Integer quantity;

    public Product() {
    }

    public Product(Long id, String productName, String skuCode) {
        this.id = id;
        this.productName = productName;
        this.skuCode = skuCode;
    }

    public Product(Long id, String productName, String skuCode, Integer quantity) {
        this.id = id;
        this.productName = productName;
        this.skuCode = skuCode;
        this.quantity = quantity;
    }

    public Product(String productName, String skuCode, Integer quantity) {
        this.productName = productName;
        this.skuCode = skuCode;
        this.quantity = quantity;
    }

    public Product(String productName, String skuCode) {
        this.productName = productName;
        this.skuCode = skuCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(productName, product.productName) && Objects.equals(skuCode, product.skuCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, skuCode);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", skuCode='" + skuCode + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
