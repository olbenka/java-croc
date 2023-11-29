package sixteen;

public class Pet {
    private Integer medicalCardNumber;
    private String name;
    private Integer age;

    public Pet(Integer medicalCardNumber, String name, Integer age) {
        this.medicalCardNumber = medicalCardNumber;
        this.name = name;
        this.age = age;
    }

    public Integer getMedicalCardNumber() {
        return medicalCardNumber;
    }

    @Override
    public String toString() {
        return "Питомец: " +
                medicalCardNumber + " " + name + " " + age;
    }

    public void setMedicalCardNumber(Integer medicalCardNumber) {
        this.medicalCardNumber = medicalCardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
