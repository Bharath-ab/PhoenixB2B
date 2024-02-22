package com.backapp;

public class Runner {
    public static void main(String[] args) {
        Bank bk = new MumbaiBranch("Bharath","Aadhar");
        System.out.println(bk);
        Bank bk2 = new MumbaiBranch("Varma",2000,"aadhar");
        System.out.println(bk2);
        Bank bk3 = new MumbaiBranch("Varma",2000,"aadhar");
        System.out.println(bk3);

    }
}
