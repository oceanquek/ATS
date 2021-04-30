package com.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private int cartId;
    private String cart;
    private List<Product> products;

    public Cart(int id,String cart) {
        this.cartId = id;
        this.cart = cart;
        products = new ArrayList<>();
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }


    public boolean addProduct(Product product) {
        switch (this.cart) {
            case "Deal":
                if (product.isOnDeal()) return products.add(product);

                return false;
            case "General":
                return products.add(product);
            default:
                throw new RuntimeException("Cart not found");
        }
    }

}
