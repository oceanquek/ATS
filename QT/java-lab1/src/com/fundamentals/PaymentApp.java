package com.fundamentals;

public class PaymentApp {
    private NetBanking banking;

    public PaymentApp() {
        banking = new NetBanking();
    }

    public void pay(float amount) {
        banking.pay(amount);
    }

    public static void main(String[] args) {
        Payment payment = new NetBanking();
    }

}


