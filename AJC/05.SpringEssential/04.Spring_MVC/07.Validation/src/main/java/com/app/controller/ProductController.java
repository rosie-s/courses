package com.app.controller;

import com.app.dao.ProductRepository;
import com.app.model.Product;
import com.app.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @ModelAttribute("product")
    public Product initProduct() {
        return new Product("Sony TV Small", 200.00, "5 images", true, 20, "20-inch sony tv");
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product, BindingResult result, Model model) {
        new ProductValidator().validate(product, result);
        if (result.hasErrors()) {
            return "/add";
        }
        model.addAttribute("product", product);
        productRepository.save(product);
        System.out.println("Product POST: " + product.toString());
        return "/product";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        System.out.println("Get Add");
        return "/add";
    }

    @GetMapping("/list")
    public String getProducts(Model model) {
        List<Product> list = new ArrayList<>();
        productRepository.findAll().forEach(list::add);
        model.addAttribute("allProducts", list);
        return "/list";
    }

    @GetMapping("/edit/{idProductEdit}")
    public String editProduct(@PathVariable long idProductEdit, Model model) {
        Product productEdit = productRepository.getOne(idProductEdit);
        model.addAttribute("idEdit", productEdit);
        model.addAttribute("idProductEdit", idProductEdit);
        System.out.println("Editing a product" + productEdit.toString());
        return "edit";
    }

    @PostMapping("/edit/{idProductEdited}")
    public String editProduct(Product productEdited, Model model, @PathVariable Long idProductEdited) {
        Product productEdit = productRepository.getOne(idProductEdited);
        productEdit.setName(productEdited.getName());
        productEdit.setUnitPrice(productEdited.getUnitPrice());
        productEdit.setImage(productEdited.getImage());
        productEdit.setAvailable(productEdited.getAvailable());
        productEdit.setQuantity(productEdited.getQuantity());
        productEdit.setDescription(productEdited.getDescription());
        model.addAttribute("idEdited", productEdited);
        System.out.println("Edited product " + productEdit.toString());
        return "edited";
    }

    @GetMapping("/delete/{idDelete}")
    public String deleteProduct(@PathVariable long idDelete, Model model, Product idProductDelete) {
        Product idProdDelete = productRepository.getOne(idDelete);
        model.addAttribute("deleteProduct", idProdDelete);
        model.addAttribute("idDelete", idDelete);
        productRepository.deleteById(idDelete);
        return "delete";
    }
}
