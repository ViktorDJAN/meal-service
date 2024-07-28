package ru.kashtanov.order_service.model;

import jakarta.persistence.*;

import java.util.Objects;

@Embeddable
public class Product {

    private Long productId;
    private String productName;
    private String skuCode;
    private Integer quantity;

    public Product() {
    }

    public Product(Long productId, String productName, String skuCode) {
        this.productId = productId;
        this.productName = productName;
        this.skuCode = skuCode;
    }

    public Product(Long productId, String productName, String skuCode, Integer quantity) {
        this.productId = productId;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
        return Objects.equals(productId, product.productId) && Objects.equals(productName, product.productName) && Objects.equals(skuCode, product.skuCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, skuCode);
    }


}
