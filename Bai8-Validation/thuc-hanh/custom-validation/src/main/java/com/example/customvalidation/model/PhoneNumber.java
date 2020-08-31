package com.example.customvalidation.model;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PhoneNumber implements Validator {
    private String number;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumber phoneNumber = (PhoneNumber) target;
        String number1 = phoneNumber.getNumber();
        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");
        if(number1.length()>11 || number1.length()<10){
            errors.rejectValue("number","number.length");
        }
        if(!number1.startsWith("0")){
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number1.matches("^$|[0-9]*$")){
            errors.rejectValue("number","number.matches");
        }

    }
}
