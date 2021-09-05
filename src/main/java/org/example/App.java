/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Turner
 */
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class App
{
    public static void handleOutput(float tax, float total) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.UP);
        System.out.println("The tax is $" + df.format(tax));
        System.out.println("The total is $" + df.format(total));
    }

    public static void handleWi(float subtotal, String county) {
        float tax;
        float total;
        if (county.contains("eau claire")) {
            tax = (float) (subtotal * (.05 + .005));
            total = subtotal + tax;
        } else if (county.contains("dunn")) {
            tax = (float) (subtotal * (.05 + .004));
            total = subtotal + tax;
        } else {
            tax = (float) (subtotal * .05);
            total = subtotal + tax;
        }
        handleOutput(tax, total);

    }

    public static void handleIl(float subtotal) {

        float tax = (float) (subtotal * .08);
        float total = (subtotal + tax);
        handleOutput(tax, total);
    }

    public static void getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        float subtotal;
        String state;
        String county;
        System.out.println("What is the order amount? ");
        subtotal = Float.parseFloat(reader.readLine());

        System.out.println("What state do you live in? ");
        state = reader.readLine().toLowerCase();

        if (state.contains("wisconsin") || state.contains("wi")) {
            System.out.println("What county do you live in? ");
            county = reader.readLine().toLowerCase();
            handleWi(subtotal, county);
        } else if (state.contains("illinois") || state.contains("il")) {
            handleIl(subtotal);
        } else {
            handleOutput(0, subtotal);
        }
    }
    public static void main( String[] args ) throws IOException {
        getInput();
    }
}
