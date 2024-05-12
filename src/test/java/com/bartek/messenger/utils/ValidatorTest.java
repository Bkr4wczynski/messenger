package com.bartek.messenger.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ValidatorTest {
    @Test
    void testPassword(){
        assertFalse(validate("", "", ""));
        assertFalse(validate("1", "Password123_", "Password123_"));
        assertFalse(validate("1234", "Password123_", "Password123"));
        assertFalse(validate("1234/", "Password123_", "Password123_"));
        assertFalse(validate("12345", "P-ass12", "P-ass12"));

        assertTrue(validate("1234", "Password123_", "Password123_"));
        assertTrue(validate("Jasiu1", "Jan4k2024_", "Jan4k2024_"));

    }
    boolean validate(String username, String pass1, String pass2){
        return Validator.CHECK_IF_PASSWORDS_ARE_IDENTICAL(pass1, pass2) && Validator.CHECK_IF_USERNAME_IS_VALID(username)
                && Validator.CHECK_IF_PASSWORD_IS_LONG_ENOUGH(pass1);
    }
}