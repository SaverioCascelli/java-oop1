package org.lessons.java.shop;

import java.text.DecimalFormat;
import java.util.Random;

public class Prodotto {

    private int barCode;
    private String name;
    private String description;
    private double price;
    private double tax;

    //    *****************CONSTRUCTOR***********************
    public Prodotto(String name, String description, double price, double tax) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.tax = tax;
        setBarCode();
    }

    public Prodotto() {
    }

    //    ******************GETTERS & SETTERS*****************

    public String getBarCode() {
        return convertCode();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getTax() {
        return tax;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    private void setBarCode() {
        Random rand = new Random();
        this.barCode = rand.nextInt(1, 1000);

    }
    //    ******************METHODS******************


    @Override
    public String toString() {
        return "Prodotto{" +
                "barCode=" + getBarCode() +
                ", name='" + name + '\'' +
                ", name-code'" + generateExtendedName() + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", tax=" + tax +
                ", totalPrice=" + generateTaxedPrice() +
                '}';
    }

    private String convertCode() {
        String code = Integer.toString(this.barCode);
        int intCodeLength = code.length();
        if (intCodeLength < 8) {
            int diff = 8 - intCodeLength;
            String temp = code;
            code = "";
            for (int i = 0; i < diff; i++) {
                code += "0";
            }
            code += temp;
        }
        return code;
    }

    private String generateExtendedName() {
        String name = this.name;
        String code = getBarCode();
        return code + "-" + name;
    }

    public String generateTaxedPrice() {
        double price = this.price;
        double totalPrice = price + price * this.tax;
        DecimalFormat df = new DecimalFormat("0.00€");
        String formattedTotalPrice = df.format(totalPrice);
        return formattedTotalPrice;
    }
}

