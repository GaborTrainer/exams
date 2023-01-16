package city;

public abstract class Building {

    private int area;

    private int levels;

    private Address address;

    protected Building(int area, Address address) {
        this(area, 1, address);
    }

    protected Building(int area, int levels, Address address) {
        this.area = area;
        this.levels = levels;
        this.address = address;
    }

    protected int getFullArea() {
        return area * levels;
    }

    protected abstract int calculateNumberOfPeopleCanFit();

    public int getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }

    public Address getAddress() {
        return address;
    }
}