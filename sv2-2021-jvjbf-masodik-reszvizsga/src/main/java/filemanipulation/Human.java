package filemanipulation;

public class Human {

    private String name;

    private String identityNumber;

    public Human(String name, String identityNumber) {
        this.name = name;
        this.identityNumber = identityNumber;
    }

    public boolean isMale() {
        return identityNumber.startsWith("1") || identityNumber.startsWith("3");
    }

    @Override
    public String toString() {
        return name + ";" + identityNumber;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getName() {
        return name;
    }
}
