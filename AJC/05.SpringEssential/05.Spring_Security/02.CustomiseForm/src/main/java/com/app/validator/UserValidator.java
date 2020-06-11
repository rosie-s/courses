package com.app.validator;


import com.app.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (!((User)o).getPassword().equals(((User) o).getPasswordConfirm())) {
            errors.rejectValue("password", "password.notsame", "Password are not equal");
        }
    }
}
