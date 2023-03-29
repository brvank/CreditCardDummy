package com.example.shivam;

public class Card {
    private String number;
    private int cvv;

    public Card(String number, int cvv) {
        this.number = number;
        this.cvv = cvv;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
