package com.domain.model;

import java.io.Serializable;

// public class Product {
public class Product implements Serializable {
    //	not accssible outside the class
    //  instance variable
    private int productId;
    private String productName;
    private float price;

    // accessor or getter
    public int getProductId() {
        return productId;
    }

    public Product(int productId, String productName, float price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    // mutator setter
    public void setProductId(int productId) {
        //this.prodictId is the instance variable
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String productString;
        productString = "Product Id : \t" + getProductId();
        productString += "\nProduct Name \t: " + getProductName();
        productString += "\nProduct Price \t: " + getPrice();
        return productString;
    }

}