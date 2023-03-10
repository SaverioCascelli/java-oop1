package org.lessons.java.bank;

import java.text.DecimalFormat;
import java.util.Random;

public class Conto {
    private int id;
    private String name;
    private double balance;


    //    ********************CONSTRUCTOR***************
    Random rand = new Random();

    public Conto(String name) {
        this.id = rand.nextInt(1, 1001);
        this.name = name;
        this.balance = 0;
    }

    public Conto() {
        this(null);
    }

    //    *******************GETTER & SETTER************
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (this.balance - amount < 0) {
            return false;
        }

        this.balance -= amount;
        return true;
    }

    public String formattedBalance() {
        DecimalFormat df = new DecimalFormat("0.00€");
        return df.format(this.balance);

    }

    @Override
    public String toString() {
        return "Conto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + formattedBalance() +
                '}';
    }
}
