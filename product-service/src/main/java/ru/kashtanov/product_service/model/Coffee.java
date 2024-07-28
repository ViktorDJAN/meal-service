package ru.kashtanov.product_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table
public class Coffee extends Product{

    private String country;

    public Coffee() {
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
