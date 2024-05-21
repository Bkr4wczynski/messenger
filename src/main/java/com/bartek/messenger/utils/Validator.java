package com.bartek.messenger.utils;

public class Validator {
    public static boolean CHECK_IF_USERNAME_IS_VALID(String username){
        if (username.isBlank())
            return false;
        if (username.length() < 3 || username.length() > 30)
            return false;
        return username.matches("^[a-zA-Z0-9_-]+$");
    }
    public static boolean CHECK_IF_PASSWORD_IS_LONG_ENOUGH(String password){
        return password.length() >= 8 && password.length() < 30;
    }
    public static boolean CHECK_IF_PASSWORDS_ARE_IDENTICAL(String password1, String password2){
        return password1.equals(password2);
    }
    public static boolean CHECK_IF_PASSWORD_IS_STRONG_ENOUGH(String password){
        System.out.println(password);
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}:;',?/*~$\\-_^+=<>]).{8,20}$");
    }
}
