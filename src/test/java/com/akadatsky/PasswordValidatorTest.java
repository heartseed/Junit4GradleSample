package com.akadatsky;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test
    public void isValid() {
        assertFalse(PasswordValidator.isValid(null));
        assertFalse(PasswordValidator.isValid("1234567"));
        assertTrue(PasswordValidator.isValid("12345678"));
    }
}