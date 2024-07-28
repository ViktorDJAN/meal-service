package ru.kashtanov.product_service.dto;

public class CoffeeRequestDto extends ProductRequestDto  {

    private String country;

    public CoffeeRequestDto(String productName, String skuCode, Integer quantity, String country) {
        super(productName, skuCode, quantity);
        this.country = country;
    }

    public CoffeeRequestDto() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
