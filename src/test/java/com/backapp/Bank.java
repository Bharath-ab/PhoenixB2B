package com.backapp;

public abstract class Bank {

    private String accountName;
    private String accountNumber;
    private double balance;
    private String kycDocument;
    private static final String BANK_NAME = "SBI";
    private static int counter = 1;

    public Bank(String accountName, String kycDocument) {
        super();
        if(checkDocument(kycDocument)){
            this.accountName = accountName;
            this.kycDocument = kycDocument;
            accountNumber = generateAccountNumber();
        }
    }

    public Bank(String accountName, double balance, String kycDocument) {
        super();
        if(checkDocument(kycDocument)){
            this.accountName = accountName;
            this.balance = balance;
            this.kycDocument = kycDocument;
            accountNumber = generateAccountNumber();

        }
    }

    public abstract boolean checkDocument(String kycDocument);

    public final void doDeposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }

    }

    private String generateAccountNumber() {
        counter++;
        return "Account Number" + counter;
    }

    @Override
    public String toString() {
        return "{" +
                "accountName='" + accountName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", kycDocument='" + kycDocument + '\'' +
                '}';
    }
}
