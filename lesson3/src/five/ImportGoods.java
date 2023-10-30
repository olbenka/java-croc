package five;

public class ImportGoods {
    private String country = "Россия";
    private boolean hasGuarantee = false;

    public ImportGoods(String country, boolean hasGuarantee) {
        this.country = country;
        this.hasGuarantee = hasGuarantee;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isHasGuarantee() {
        return hasGuarantee;
    }

    public void setHasGuarantee(boolean hasGuarantee) {
        this.hasGuarantee = hasGuarantee;
    }

    @Override
    public String toString() {
        return ("Cтрана: " + country + "\nНаличие гарантии: " + (hasGuarantee ? "Да" : "Нет"));
    }
}
