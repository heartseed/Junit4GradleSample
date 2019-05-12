package com.akadatsky;

public class PasswordValidator {

    /**
     * @param password
     * @return true if passwod is valid
     */
    public static boolean isValid(String password) {
        if (password == null) {
            return false;
        }
        return password.length() >= 8;
    }

}
