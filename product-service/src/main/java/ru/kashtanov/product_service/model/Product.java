package ru.kashtanov.product_service.model;

import jakarta.persistence.*;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String productName;
    @Column
    private String skuCode;
    @Column
    private Integer quantity;

    public Product(Long id, String productName, String skuCode) {
        this.id = id;
        this.productName = productName;
        this.skuCode = skuCode;
    }

    public Product(String productName, String skuCode, Integer quantity) {
        this.productName = productName;
        this.skuCode = skuCode;
        this.quantity = quantity;
    }

    public Product() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
