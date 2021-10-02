package lt.gybe.vu.mif;

import java.util.ArrayList;

public class PasswordChecker {

    private ArrayList<Character> specialSymbols;

    private int minLength;
    private int maxLength;


    public PasswordChecker() {
        setDefaultSpecialSymbols();
    }

    public int getMinLength(){
        return minLength;
    }

    public void setMinLength(int length){
        this.minLength = length;
        if (getMinLength() <= 0) throw new IllegalArgumentException();
        if (getMaxLength() !=0 && getMinLength()>=getMaxLength()) throw new IllegalArgumentException();

    }

    public int getMaxLength(){
        return maxLength;
    }

    public void setMaxLength(int length){
        this.maxLength = length;
        if (getMaxLength() <= 0) throw new IllegalArgumentException();
        if (getMinLength() != 0 && getMaxLength() <= getMinLength()) throw new IllegalArgumentException();
    }

    public ArrayList<Character> getSpecialSymbols() {
        return specialSymbols;
    }

    public void setSpecialSymbols(ArrayList<Character> specialSymbols) {
        this.specialSymbols = specialSymbols;
    }

    public void setSpecialSymbols(char[] specialSymbols) {
        this.specialSymbols.clear();
        for (char specialSymbol : specialSymbols) this.specialSymbols.add(specialSymbol);
    }


    public boolean isPasswordValid(String password) {
        return isPasswordLengthValid(password)
                && isStringContainsUpperCaseSymbol(password)
                && isStringContainsSpecialCharacters(password);
    }

    public void addSpecialSymbol(char symbol) {
        for (Character specialSymbol : specialSymbols) {
            if (specialSymbol == symbol) return;
        }
        specialSymbols.add(symbol);
    }

    public void removeSpecialSymbol(char symbol) {
        if (specialSymbols.contains(symbol)) specialSymbols.remove(symbol);
    }

    private void setDefaultSpecialSymbols() {
        //" !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~"
        ArrayList<Character> specialSymbols = new ArrayList<>();

        specialSymbols.add('!');
        specialSymbols.add(' ');
        specialSymbols.add('"');
        specialSymbols.add('#');
        specialSymbols.add('$');
        specialSymbols.add('%');
        specialSymbols.add('&');
        specialSymbols.add('\'');
        specialSymbols.add('(');
        specialSymbols.add(')');
        specialSymbols.add('*');
        specialSymbols.add('+');
        specialSymbols.add(',');
        specialSymbols.add('-');
        specialSymbols.add('.');
        specialSymbols.add('/');
        specialSymbols.add(':');
        specialSymbols.add(';');
        specialSymbols.add('<');
        specialSymbols.add('=');
        specialSymbols.add('>');
        specialSymbols.add('?');
        specialSymbols.add('@');
        specialSymbols.add('[');
        specialSymbols.add('\\');
        specialSymbols.add('^');
        specialSymbols.add('_');
        specialSymbols.add('`');
        specialSymbols.add('{');
        specialSymbols.add('|');
        specialSymbols.add('}');
        specialSymbols.add('~');

        setSpecialSymbols(specialSymbols);
    }

    private boolean isPasswordLengthValid(String password) {
        if (password == null) throw new IllegalArgumentException();
        else if (password.isEmpty()) return false;
        return (password.length() >= getMinLength()
                && password.length() <= getMaxLength());
    }

    private boolean isStringContainsUpperCaseSymbol(String password) {
        char ch;
        boolean capitalFlag = false;

        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) capitalFlag = true;
            if (capitalFlag) return true;
        }

        return false;
    }

    private boolean isStringContainsSpecialCharacters(String password){

        for (Character specialSymbol : specialSymbols) {
            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(j) == specialSymbol) return true;
            }
        }
        return false;
    }
    
}
