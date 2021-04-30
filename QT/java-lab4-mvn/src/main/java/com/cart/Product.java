package com.cart;

public class Product {
    private String name;
    private boolean onDeal;

    public Product(String name,boolean onDeal) {
        this.name = name;
        this.onDeal = onDeal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnDeal() {
        return onDeal;
    }

    public void setOnDeal(boolean onDeal) {
        this.onDeal = onDeal;
    }
}
