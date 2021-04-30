package com.fundamentals;

public class NetBanking implements Payment,FundTransfer {
    @Override
    public void saveTransactionReport() {

    }

    @Override
    public void validate() {
        System.out.println("Validated at Net banking");
    }

    @Override
    public void pay(float amount) {
        System.out.println("Paid: " + amount);
    }

    @Override
    public void transferFunds(float amount) {
        System.out.println("Transfered: " + amount);
    }

}