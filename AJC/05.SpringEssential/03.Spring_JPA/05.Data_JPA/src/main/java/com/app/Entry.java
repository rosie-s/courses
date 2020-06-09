package com.app;

import com.app.config.AppConfig;
import com.app.dao.ProductDAO;
import com.app.dao.ProductRepository;
import com.app.model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Entry {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext contextAnnotation = new AnnotationConfigApplicationContext(AppConfig.class);


        ProductDAO productDAO =  contextAnnotation.getBean(ProductDAO.class);
        ProductRepository productRepository = contextAnnotation.getBean(ProductRepository.class);

        Product laptop = new Product("MSE-GE73", 1800.00, "No image", true, 25 ,  "Gaming laptop");
        Product television = new Product("Sony TV", 2000.00, "5 images", false, 3 ,  "60-inch sony tv");
        Product television2 = new Product("Sony TV Small", 200.00, "5 images", true, 20 ,  "20-inch sony tv");
        Product iPad = new Product("iPad Pro", 899.00, "12 images", true, 30 ,  "12 inch iPad Pro");
        productDAO.create(laptop);
        productDAO.create(television);
        productDAO.create(television2);
        productDAO.create(iPad);
        productDAO.findAll();

        System.out.println("Unit price between: " +  productRepository.findAllByUnitPriceBetween(900,2000).size());
        System.out.println("Description containing sony: " + productRepository.findAllByDescriptionIsContaining("sony").size());
        System.out.println("Named Query: Description containing sony: " + productRepository.findByDescriptionContaining("sony").size());

    }
}
