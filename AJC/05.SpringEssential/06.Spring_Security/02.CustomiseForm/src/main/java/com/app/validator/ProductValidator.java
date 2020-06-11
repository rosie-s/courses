package com.app.validator;

import com.app.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Product.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "product.name", "Product name cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "unitPrice", "product.unitPrice", "Unit price cannot be empty");
    }
}
