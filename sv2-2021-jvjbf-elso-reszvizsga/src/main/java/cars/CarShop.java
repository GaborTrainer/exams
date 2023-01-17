package cars;

import java.util.ArrayList;
import java.util.List;

public class CarShop {

    private String name;
    private int maxPrice;
    private List<Car> carsForSell = new ArrayList<>();

    public CarShop(String name, int maxPrice) {
        this.name = name;
        this.maxPrice = maxPrice;
    }

    public boolean addCar(Car car) {
        return car.getPrice() <= maxPrice && carsForSell.add(car);
    }

    public int sumCarPrice() {
        return carsForSell.stream()
                .mapToInt(Car::getPrice)
                .sum();
    }

    public int numberOfCarsCheaperThan(int price) {
        return (int) carsForSell.stream()
                .filter(car -> car.getPrice() <= price)
                .count();
    }

    public List<Car> carsWithBrand(String brand) {
        return carsForSell.stream()
                .filter(car -> car.getBrand().equals(brand))
                .toList();
    }

    public String getName() {
        return name;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public List<Car> getCarsForSell() {
        return carsForSell;
    }
}