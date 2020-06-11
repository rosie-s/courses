package com.app.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Entity
@Transactional
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Double unitPrice;

    @Length(min = 3, message = "Image requires more than 3 characters")
    String image;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Temporal(TemporalType.DATE)
    Date productDate;
    Boolean available;
    //Integer categoryId;
    Integer quantity;
    String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    Category category;

    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;

    public Product() {
    }

    public Product(String name, Double unitPrice, String image, Boolean available, Integer quantity, String description) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.image = image;
        this.available = available;
        this.quantity = quantity;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", image='" + image + '\'' +
                ", available=" + available +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

}
