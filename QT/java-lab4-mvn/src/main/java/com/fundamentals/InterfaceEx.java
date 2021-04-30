package com.fundamentals;

public class InterfaceEx {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard();
        creditCard.validate();
        creditCard.pay((float)1.50);
        creditCard.saveTransactionReport();
    }
}

interface Transaction {
    public abstract void saveTransactionReport();
    public void validate();
}


class CreditCard implements Payment {

    public void validate() {
        System.out.println("Validate credit card...");
    }

    @Override
    public void saveTransactionReport() {
        System.out.println("Save report");
    }


    @Override
    public void pay(float amount) {

    }
}




