package com.backapp;

public class MumbaiBranch extends Maharastra {
    public MumbaiBranch(String accountName, String kycDocument) {
        super(accountName, kycDocument);
    }

    public MumbaiBranch(String accountName, double balance, String kycDocument) {
        super(accountName, balance, kycDocument);
    }

    public boolean checkDocument(String document){
        if(document.equalsIgnoreCase("AADHAR"))
            return true;
        else {
            System.err.println("Invalid Document Require AADHAR as KYC");
             return false;
        }
    }

    @Override
    public String toString() {

        return "KothaPetaBranch " + super.toString();
    }

        public void applyForLoan(){
        if(issueLoan()){
            System.out.println("Eligible for Loan: ");
        }
    }
}
