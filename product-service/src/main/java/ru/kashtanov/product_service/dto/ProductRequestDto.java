package ru.kashtanov.product_service.dto;

public class ProductRequestDto {
    private String productName;
    private String skuCode;
    private Integer quantity;

    public ProductRequestDto(String productName, String skuCode, Integer quantity) {
        this.productName = productName;
        this.skuCode = skuCode;
        this.quantity = quantity;
    }

    public ProductRequestDto() {
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
}
