package city;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class City {

    private String name;

    private long fullArea;

    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void addBuilding(Building building) {
        int actualArea = buildings.stream().mapToInt(Building::getArea).sum();
        if (actualArea + building.getArea() > fullArea) {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
        buildings.add(building);
    }

    public Building findHighestBuilding() {
        return buildings.stream()
                .max(Comparator.comparing(Building::getLevels))
                .orElseThrow();
    }

    public List<Building> findBuildingsByStreet(String street) {
        return buildings.stream()
                .filter(building -> building.getAddress().getStreet().equals(street))
                .toList();
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        return buildings.stream()
                .anyMatch(building -> building.calculateNumberOfPeopleCanFit() > numberOfPeople);
    }
}
