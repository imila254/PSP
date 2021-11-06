package com.psp.psp13.adapter;

import com.company.PhoneValidator;

public class PhoneNumberValidatorWrapper implements PhoneNumberValidatorWrappable{
    private PhoneValidator phoneValidator;

    public PhoneNumberValidatorWrapper(PhoneValidator phoneValidator){
        this.phoneValidator = phoneValidator;
    }

    @Override
    public boolean isPhoneNumberContainsValidSymbols(String number){
        if (phoneValidator.checkCountryCode(number, "Lithuania")) return phoneValidator.onlyNumbers(number.substring(4));
        else if(number.startsWith("86")) return phoneValidator.onlyNumbers(number);
        else return false;
    }

    @Override
    public boolean isPhoneLengthValid(String number){
        if (number.startsWith("+370")) return phoneValidator.numberLength(number.substring(4), 8);
        else if(number.startsWith("86")) return phoneValidator.numberLength(number,9);
        return false;
    }

    public String numberFormer(String number){
        String newPhoneNumber;
        if (number.startsWith("86")){
            newPhoneNumber = '+' + number.replace("8", "370");
            return newPhoneNumber;
        }
        else return number;
    }

}
