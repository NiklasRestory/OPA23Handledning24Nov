package org.example;

public class Transaktion {
    private String fromKonto;
    private String toKonto;
    private int amount;

    public Transaktion(String fromKonto, String toKonto, int amount) {
        this.fromKonto = fromKonto;
        this.toKonto = toKonto;
        this.amount = amount;
    }

    public String getFromKonto() {
        return fromKonto;
    }

    public void setFromKonto(String fromKonto) {
        this.fromKonto = fromKonto;
    }

    public String getToKonto() {
        return toKonto;
    }

    public void setToKonto(String toKonto) {
        this.toKonto = toKonto;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
