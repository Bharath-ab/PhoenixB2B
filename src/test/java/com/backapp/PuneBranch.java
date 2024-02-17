package com.backapp;

public class PuneBranch extends Maharastra implements CreditCard {
    public PuneBranch(String accountName, String kycDocument) {
        super(accountName, kycDocument);
    }

    public PuneBranch(String accountName, double balance, String kycDocument) {
        super(accountName, balance, kycDocument);
    }

    @Override
    public boolean checkDocument(String kycDocument) {
        if (kycDocument.equalsIgnoreCase(("DL")))
            return true;
        else {
            System.out.println("KYC document is not sufficient please provide DL");
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean issueCreditCard() {
        return true;
    }

    public void applyForLoan(){
        if(issueLoan()){
            System.out.println("Eligible for Loan: ");
        }
    }

    public void applyForCreditCard(){
        if(issueCreditCard()){
            System.out.println("Eligible for Credit Card");
        }
    }
}
