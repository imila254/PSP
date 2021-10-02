package lt.gybe.vu.mif;

public class EmailValidator {

    public boolean isEmailValid(String email) {
        if (email == null) throw new IllegalArgumentException();
        return !email.trim().isEmpty() && !isRecipientNameInvalid(email) && !isDomainNameInvalid(email);
    }

    private boolean specialCharacterOccursAsFirstOrLastInRecipient(String recipient, char[] specialChars){
        for (char specialChar : specialChars) {
            if (recipient.charAt(0) == specialChar
                    || recipient.charAt(recipient.length() - 1) == specialChar)
                return true;
        }
        return false;
    }

    private boolean specialCharacterOccursConsecutivelyInRecipient(String recipient, char[] specialChars){
        int counter;
        for (char specialChar : specialChars) {
            counter = 0;
            for (int i = 0; i < recipient.length(); i++) {
                if (recipient.charAt(i) == specialChar) counter++;
                else if (counter > 0) break;
            }
            if (counter > 1) {
                return true;
            }
        }
        return false;
    }


    private boolean isRecipientNameInvalid(String email){
        String recipient;
        char[] specialChars = new char[] {'(', ')', '~', '[', ']', '\"', '"',',',':',';', '>', '<', '@'};
        char [] legalSpecialChars = new char[] {'.', '!', '#', '$', '%', '&', '\'', '*', '+', '-', '/', '=', '?', '^', '_', '`', '{', '|', '}'};

        if (email.contains("@"))  recipient = email.substring(0, email.indexOf('@'));
        else return true;

        return recipient.length() > 64
                || recipient.length() == 0
                || recipient.contains("@")
                || isWithInvalidSymbol(recipient, specialChars)
                || specialCharacterOccursAsFirstOrLastInRecipient(recipient, legalSpecialChars)
                || specialCharacterOccursConsecutivelyInRecipient(recipient, legalSpecialChars);
    }

    private boolean isDomainNameInvalid(String email){
        String domainName;
        String domainTLD;
        char [] illegalDomainNameChars = new char[] {
                ',', '(', ')', '~', '[', ']', '\"', '"',',',':',';', '>', '<', '@','-',
                '!', '#', '$', '%', '&', '\'', '*', '+', '/', '=', '?', '^', '_', '`', '{', '|', '}'};

        if (email.contains("@") && email.substring(email.indexOf("@")).contains(".")) {
            domainTLD = email.substring(email.lastIndexOf('.')+1);
            domainName = email.substring(email.indexOf('@')+1, email.lastIndexOf('.'));
        }
        else return true;

        return domainName.length() > 253
                || domainName.length() == 0
                || isWithInvalidSymbol(domainName, illegalDomainNameChars)
                || !isStringLowerCase(domainTLD)
                || isWithInvalidSymbol(domainTLD, illegalDomainNameChars)
                || isInt(domainName);
    }

    public boolean isInt(String domainName) {
        String str = domainName.replace(".", "");

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    private boolean isStringLowerCase(String domainTLD){

        char[] charArray = domainTLD.toCharArray();

        for (char c : charArray) {
            if (!Character.isLowerCase(c))
                return false;
        }
        return true;
    }

    private boolean isWithInvalidSymbol (String email, char[] specialChars){
        for (char specialChar : specialChars) if (email.indexOf(specialChar) >= 0) return true;
        return false;
    }

}
