package com.myapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public String companyName;
    public String bankAccountNumber;

    @JsonIgnoreProperties("provider")
    @OneToMany(mappedBy = "provider", fetch = FetchType.EAGER)
    List<Product> providerProducts = new ArrayList<>();

    public Provider() {
    }

    public Provider(Long id, String companyName, String bankAccountNumber) {
        this.id = id;
        this.companyName = companyName;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public List<Product> getProviderProducts() {
        return providerProducts;
    }

    public void setProviderProducts(List<Product> providerProducts) {
        this.providerProducts = providerProducts;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                '}';
    }
}
