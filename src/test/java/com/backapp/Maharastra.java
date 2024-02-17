package com.backapp;

public abstract class Maharastra extends Bank implements Loan{

    public Maharastra(String accountName, String kycDocument) {
        super(accountName, kycDocument);
    }

    public Maharastra(String accountName, double balance, String kycDocument) {
        super(accountName, balance, kycDocument);
    }

    public boolean issueLoan() {
        return true;
    }
}
