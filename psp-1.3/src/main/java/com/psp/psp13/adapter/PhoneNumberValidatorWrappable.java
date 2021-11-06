package com.psp.psp13.adapter;

public interface PhoneNumberValidatorWrappable {
    boolean isPhoneNumberContainsValidSymbols(String number);

    boolean isPhoneLengthValid(String number);

    String numberFormer(String number);

}
