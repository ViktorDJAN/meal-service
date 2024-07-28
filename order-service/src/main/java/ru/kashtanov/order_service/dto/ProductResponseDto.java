package ru.kashtanov.order_service.dto;

import jakarta.persistence.Column;

public class ProductResponseDto {
    private String productName;
    private String skuCode;
    private Integer quantity;

    public ProductResponseDto() {
    }

    public ProductResponseDto(String productName, String skuCode) {
        this.productName = productName;
        this.skuCode = skuCode;
    }

    public ProductResponseDto(String productName, String skuCode, Integer quantity) {
        this.productName = productName;
        this.skuCode = skuCode;
        this.quantity = quantity;
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
    public String toString() {
        return "ProductResponseDto{" +
                "productName='" + productName + '\'' +
                ", skuCode='" + skuCode + '\'' +
                '}';
    }
}
