package com.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Products")
@NamedQueries({
        @NamedQuery(name = "Product.findByDescriptionContaining",
                query = "select p from Product p where lower(p.description) like CONCAT(:word,'%')"
                        )})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Double unitPrice;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
