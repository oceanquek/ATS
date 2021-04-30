package com.fundamentals;

public interface Payment extends Transaction {
    void pay(float amount);
}