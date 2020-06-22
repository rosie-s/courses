package com.demomicro.cartservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class ProductList {
    List<Product> products;
}
