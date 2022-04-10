package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String[] arrayInt = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "A", "B", "C", "D", "E", "F"};
    static int borderFrom = 0;
    static int borderTo = 10000;

    public static void main(String[] args) {

        int originalInt;

        System.out.println("Enter a number to convert to hexadecimal number system (a number from 0 to 10000)");
        System.out.print("-->");

        try {
            originalInt = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("number entry error");
            return;
        }

        if (originalInt < borderFrom || originalInt > borderTo) {
            System.out.println("The number does not meet the limits from 0 to 10000");
            return;
        }

        String newIntUsingToHexString = Integer.toHexString(originalInt);
        StringBuilder newInt = new StringBuilder();
        int divider;
        int remainder;
        while(originalInt > 0){

            if(originalInt >= 16) {
                divider = originalInt / 16;
                remainder = originalInt - divider * 16;
                newInt.insert(0, arrayInt[remainder]);
                originalInt = divider;
            }else{
                newInt.insert(0, arrayInt[originalInt]);
                originalInt = 0;
            }
        }

        System.out.println("number in hexadecimal number system: " + newInt);
        System.out.println("number in hexadecimal number system using toHexString:" + newIntUsingToHexString);
    }
}
