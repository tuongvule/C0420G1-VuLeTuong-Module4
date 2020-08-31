package com.example.userregisterform.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User implements Validator {
    @NotEmpty(message = "first name can not be left empty")
    @Size(min=5, max = 45,message = "first name must be between 5 and 45 characters")
    private String firstName;

    @NotEmpty(message = "last name can not be left empty")
    @Size(min=5, max = 45, message = "last name must be between 5 and 45 characters")
    private String lastName;


    private String phoneNumber;

    @Min(value = 18, message = "age must be over 18")
    private int age;

    @Email(message = "email must be in the format abc@abc.com")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String number = user.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors,"phoneNumber","phoneNumber.empty");
        if(number.length()>11 || number.length()<10){
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }
        if(!number.startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }
        if(!number.matches("^$|[0-9]*$")){
            errors.rejectValue("phoneNumber","phoneNumber.matches");
        }
    }
}
