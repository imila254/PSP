package lt.gybe.vu.mif;

public class PhoneNumberInformation {
    private String internationalPrefix;
    private int[] lengths;
    private String localPrefix;

    PhoneNumberInformation(String internationalPrefix, String localPrefix, int[] lengths){
        this.setInternationalPrefix(internationalPrefix);
        this.setLengths(lengths);
        this.setLocalPrefix(localPrefix);
    }

    public String getInternationalPrefix() {
        return internationalPrefix;
    }

    public void setInternationalPrefix(String internationalPrefix) {
        this.internationalPrefix = internationalPrefix;
    }

    public int[] getLengths() {
        return lengths;
    }

    public void setLengths(int[] lengths) {
        this.lengths = lengths;
    }

    public String getLocalPrefix() {
        return localPrefix;
    }

    public void setLocalPrefix(String localPrefix) {
        this.localPrefix = localPrefix;
    }

}
