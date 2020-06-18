package com.myapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    String id;
    String password;
    String fullname;
    String email;
    String photo;
    Boolean activated;
    Boolean admin = false;

    @JsonIgnoreProperties("customer")
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    List<Product> customerProducts = new ArrayList<>();


    public Customer(String id, String password, String fullname, String email, String photo, Boolean activated, Boolean admin) {
        this.id = id;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.photo = photo;
        this.activated = activated;
        this.admin = admin;
    }

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public List<Product> getCustomerProducts() {
        return customerProducts;
    }

    public void setCustomerProducts(List<Product> customerProducts) {
        this.customerProducts = customerProducts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", activated=" + activated +
                ", admin=" + admin +
                ", customerProducts=" + customerProducts +
                '}';
    }
}
