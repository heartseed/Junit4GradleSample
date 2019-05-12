package com.akadatsky;

import java.util.Scanner;

public class Main {

    /*
     * 1: Password Validator Tool:
     * Utility class with method  to validate password strength
     * JUnit Test for this class
     * Runnable main method to validate user console input.
     * Rule: Passwords with length >= 8 are valid, others - not valid
     */
    public static void main(String[] args) {
        System.out.println("Please enter password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        if (PasswordValidator.isValid(password)) {
            System.out.println("Your password is valid");
        } else {
            System.out.println("Your password is not valid");
        }
    }

}
