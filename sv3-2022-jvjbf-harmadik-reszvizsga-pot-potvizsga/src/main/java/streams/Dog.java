package streams;

public class Dog {

    private String name;

    private int age;

    private Size size;

    private String breed;

    public Dog(String name, int age, Size size, String breed) {
        this.name = name;
        this.age = age;
        this.size = size;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Size getSize() {
        return size;
    }

    public String getBreed() {
        return breed;
    }
}
