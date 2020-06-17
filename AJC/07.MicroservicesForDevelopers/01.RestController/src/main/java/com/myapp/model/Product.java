package com.myapp.model;

public class Product {
    Long id;
    String name;
    Double unitPrice;
    Boolean available;
    Integer quantity;
    String description;

    public Product() {

    }

    public Product(Long id, String name, Double unitPrice, Boolean available, Integer quantity, String description) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.available = available;
        this.quantity = quantity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
