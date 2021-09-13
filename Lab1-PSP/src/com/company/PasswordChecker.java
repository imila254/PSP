package com.company;

public class PasswordChecker {

    public boolean isPasswordLengthValid(String password, int X) {
        return password.length() >= X;
    }

    public boolean isStringContainsUpperCaseSymbol(String password) {
        char ch;
        boolean capitalFlag = false;

        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) capitalFlag = true;
            if (capitalFlag) return true;
        }

        return false;
    }

    public boolean isStringContainsSpecialCharacters(String password123) {
        return true;
    }
}
