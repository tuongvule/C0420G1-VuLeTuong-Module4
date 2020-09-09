package com.example.giohang.model;


import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cart = new HashMap<>();


    public void addToCart(Product product){
        if(cart.containsKey(product)){
            cart.replace(product,cart.get(product)+1);
        }else {
            cart.put(product,1);
        }
    }
    public void decreaseFromCart(Product product){
//        if(cart.get(product)<0)
        if(cart.containsKey(product) && cart.get(product)>0){
            cart.replace(product,cart.get(product)-1);
        }
    }
    public void increaseFromCart(Product product){
        if(cart.containsKey(product)){
            cart.replace(product,cart.get(product)+1);
        }
    }

    public void removeProduct(Product product){
        cart.remove(product);
    }

    public int getAmount(Product product){
        return cart.get(product);
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }
}
