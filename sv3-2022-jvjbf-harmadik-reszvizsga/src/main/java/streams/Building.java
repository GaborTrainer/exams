package streams;

public class Building {

    private String street;

    private int area;

    private int levels;

    public Building(String street, int area, int levels) {
        this.street = street;
        this.area = area;
        this.levels = levels;
    }

    public String getStreet() {
        return street;
    }

    public int getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }
}
