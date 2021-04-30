package com.fundamentals;

public class FundTransferApp {

    public static void main(String[] args) {
        FundTransfer transfer = new NetBanking();
        transfer.transferFunds(10);
    }

}