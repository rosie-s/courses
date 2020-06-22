package com.demomicro.cartservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductItem {
    private int id;
    private String product_name;
    private String category_name;
}
