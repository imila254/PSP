package com.psp.psp13.adapter;

import com.company.PhoneValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberValidatorWrapperTest {
    PhoneValidator phoneValidator = new PhoneValidator();
    PhoneNumberValidatorWrapper phoneNumberValidatorWrapper = new PhoneNumberValidatorWrapper(phoneValidator);

    @ParameterizedTest
    @ValueSource(strings = {"+37061111111", "861111111"})
    void isPhoneNumberContainsValidSymbols_True_Test(String string){
        assertTrue(phoneNumberValidatorWrapper.isPhoneNumberContainsValidSymbols(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+3706a111111", "a61111111", "37067111111", "", " "})
    void isPhoneNumberContainsValidSymbols_False_Test(String string){
        assertFalse(phoneNumberValidatorWrapper.isPhoneNumberContainsValidSymbols(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+37061111111", "861111111"})
    void isPhoneLengthValid_True_Test(String string){
        assertTrue(phoneNumberValidatorWrapper.isPhoneLengthValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+3706111111", "8611111"})
    void isPhoneLengthValid_False_Test(String string){
        assertFalse(phoneNumberValidatorWrapper.isPhoneLengthValid(string));
    }

    @Test
    void numberFormer_Test(){
        assertEquals("+37061111111", phoneNumberValidatorWrapper.numberFormer("861111111"));
    }

}
