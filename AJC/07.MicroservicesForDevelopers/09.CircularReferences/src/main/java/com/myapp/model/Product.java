package com.myapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    Double unitPrice;
    Boolean available;
    Integer quantity;
    String description;

    @JsonIgnoreProperties("products")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    Category category;

    @JsonIgnoreProperties("providerProducts")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "providerId")
    Provider provider;

    @JsonIgnoreProperties("customerProducts")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    Customer customer;

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

    public Category getCategory() {
        return category;
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

    public void setCategory(Category category) {
        this.category = category;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", available=" + available +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
    }
}
