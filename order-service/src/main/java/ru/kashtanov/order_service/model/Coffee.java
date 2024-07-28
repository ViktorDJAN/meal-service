package ru.kashtanov.order_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;


public class Coffee extends Product {
    private String country;

    public Coffee() {
    }

    public Coffee(Long productId, String productName, String skuCode, Integer quantity, String country) {
        super(productId, productName, skuCode, quantity);
        this.country = country;
    }

    public Coffee(String productName, String skuCode, Integer quantity, String country) {
        super(productName, skuCode, quantity);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "country='" + country + '\'' +
                '}';
    }
}
