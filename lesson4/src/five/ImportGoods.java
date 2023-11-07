package five;

public class ImportGoods {
    private String country;
    private boolean hasGuarantee;

    public ImportGoods(String country, boolean hasGuarantee) {
        this.country = country;
        this.hasGuarantee = hasGuarantee;
    }


    @Override
    public String toString() {
        return ("Cтрана: " + country + "\nНаличие гарантии: " + (hasGuarantee ? "Да" : "Нет"));
    }
}
