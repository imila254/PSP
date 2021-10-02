package lt.gybe.vu.mif;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneValidator {

    public Map<String, PhoneNumberInformation> countries = new HashMap<>();

    public boolean isPhoneNumberValid(String phoneNumber, String country) {
        if (country == null) throw new IllegalArgumentException();

        PhoneNumberInformation information = countries.get(country.toLowerCase());

        if (information == null || !countries.containsKey(country.toLowerCase())) throw new IllegalArgumentException();
        else return isNumberLengthValid(phoneNumber, country.toLowerCase()) && isNumberSymbolsValid(phoneNumber.toLowerCase());
    }

    /**
     * This method is used to add new country entry, so that phone number format
     * of this country would pass the validation.
     * @param title Country name or code;
     * @param lengths Lengths of the phone number with local prefix
     * @param localPrefix Local prefix of the phone number
     * @param internationalPrefix International prefix, to be used if phone number with local one provided
     */

    public void addCountryValidation(String title, int[] lengths, String localPrefix, String internationalPrefix) {
        if (isCountryParametersValid(title,lengths,localPrefix,internationalPrefix)){
            countries.put(title.toLowerCase(), new PhoneNumberInformation(internationalPrefix,localPrefix, lengths));
        }
    }

    private boolean isCountryParametersValid(String title, int[] lengths, String localPrefix, String internationalPrefix){
        if (title == null || lengths == null || localPrefix == null || internationalPrefix == null
                || title.trim().isEmpty() || lengths.length == 0 || internationalPrefix.trim().isEmpty()
                || (!isInt(localPrefix) && !localPrefix.trim().isEmpty())
                || (!localPrefix.trim().isEmpty() && (localPrefix.charAt(0) == '+' || localPrefix.charAt(0) == '-' ))
                || !isInt(internationalPrefix) || internationalPrefix.charAt(0) == '+' || internationalPrefix.charAt(0) == '-'
        ) throw new IllegalArgumentException();

        for (int length : lengths) {
            if (length <= 0
                    || internationalPrefix.length() >= length
                    || localPrefix.length() >= length) throw new IllegalArgumentException();
        }

        if (!countries.containsKey(title.toLowerCase())){
            for (String key : countries.keySet()) {
                if (Objects.equals(countries.get(key).getInternationalPrefix(), internationalPrefix))
                    throw new IllegalArgumentException();
            }
        }
        return true;
    }

    private boolean isNumberLengthValid(String phoneNumber, String country){
        if (phoneNumber == null || country == null) throw new IllegalArgumentException();
        else if (phoneNumber.trim().isEmpty() || country.trim().isEmpty()) return false;

        for (int i=0;i<countries.get(country).getLengths().length; i++) {
            if ( (countries.get(country).getLengths()[i] == (phoneNumber.length() - countries.get(country).getInternationalPrefix().length()))
                    ||  (countries.get(country).getLengths()[i] == (phoneNumber.length() - countries.get(country).getLocalPrefix().length()))
            ) return true;
        }

        return false;
    }

    private boolean isNumberSymbolsValid(String phoneNumber){
        return isInt(phoneNumber) && phoneNumber.charAt(0) != '+' && phoneNumber.charAt(0) != '-';
    }

    private boolean isInt(String number) {
        try {
            Long.parseLong(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public String replaceLocalPrefixToInternationalPrefix(String country, String phoneNumber){
        String newPhoneNumber;
        String local;
        String international;

        local = countries.get(country.toLowerCase()).getLocalPrefix();
        international = countries.get(country.toLowerCase()).getInternationalPrefix();

        newPhoneNumber = '+' +  phoneNumber.replace(local, international);

        return newPhoneNumber;

    }

}

