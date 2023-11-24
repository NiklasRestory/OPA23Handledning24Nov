package org.example;

public class Konto {
    private String kontonummer;
    private int balance;

    public Konto(String kontonummer, int balance) {
        this.kontonummer = kontonummer;
        this.balance = balance;
    }

    public String getKontonummer() {
        return kontonummer;
    }
    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
