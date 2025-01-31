package net.rewerk.appliances.utils;

import net.rewerk.appliances.exceptions.InvalidInputException;

import java.util.Scanner;

public class Utils {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static double scanDouble(boolean recursive) {
        double result;
        try {
            result = SCANNER.nextDouble();
        } catch (Exception e) {
            System.out.println("Please enter a valid number or double value");
            if (recursive) {
                SCANNER.nextLine();
                result = scanDouble(recursive);
            } else throw new InvalidInputException("Invalid input provided");
        }
        return result;
    }

    public static double scanDouble(String prompt, boolean recursive) {
        System.out.println(prompt);
        return scanDouble(recursive);
    }
}
