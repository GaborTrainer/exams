package cars;

public class Car {

    private String brand;

    private double engineSize;

    private Color color;

    private int price;

    public Car(String brand, double engineSize, Color color, int price) {
        this.brand = brand;
        this.engineSize = engineSize;
        this.color = color;
        this.price = price;
    }

    public void decreasePrice(int percent) {
        if (percent >= 1 && percent <= 99) {
            price *= (100 - percent) / 100.0;
        }
    }

    public String getBrand() {
        return brand;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public Color getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }
}
