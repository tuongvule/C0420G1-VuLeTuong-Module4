package com.codegym.democreatespringboot.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Customer implements Validator {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotEmpty(message = "tên không được để trống")
    @Size(min = 3, max = 20, message = "first name phai tu 3 den 20 ky tu")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty
    @Size(min = 3, max = 20)
    private String lastName;

    @Column(name = "phone")
    private String phone;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    @Override
//    public String toString() {
//        return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;
        String number = customer.getPhone();
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("phone", "phone.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("phone", "phone.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone", "phone.matches");
        }
    }
}