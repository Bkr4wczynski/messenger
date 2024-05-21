package com.bartek.messenger.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ValidatorTest {
    @Test
    void testPassword(){
        assertTrue(Validator.CHECK_IF_PASSWORD_IS_LONG_ENOUGH("1234567899"));
        assertFalse(Validator.CHECK_IF_PASSWORD_IS_LONG_ENOUGH("asdwe3"));

        assertTrue(Validator.CHECK_IF_PASSWORDS_ARE_IDENTICAL("Seks2024", "Seks2024"));
        assertFalse(Validator.CHECK_IF_PASSWORDS_ARE_IDENTICAL("Abcd9909", "abcd9909"));
        assertFalse(Validator.CHECK_IF_PASSWORDS_ARE_IDENTICAL("Abcd9909", "aawhh9909"));

        assertFalse(Validator.CHECK_IF_PASSWORD_IS_STRONG_ENOUGH("abcd"));
        assertFalse(Validator.CHECK_IF_PASSWORD_IS_STRONG_ENOUGH("abcdqwerty"));
        assertFalse(Validator.CHECK_IF_PASSWORD_IS_STRONG_ENOUGH("abcd990987"));
        assertFalse(Validator.CHECK_IF_PASSWORD_IS_STRONG_ENOUGH("ABcd9912345"));

        assertTrue(Validator.CHECK_IF_PASSWORD_IS_STRONG_ENOUGH("ABcd_9910"));
        assertTrue(Validator.CHECK_IF_PASSWORD_IS_STRONG_ENOUGH("G00D_P4ssw0rD!"));

    }

}