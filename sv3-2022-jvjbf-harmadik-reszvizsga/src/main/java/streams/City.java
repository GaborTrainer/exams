package streams;

import java.util.*;
import java.util.stream.Collectors;

public class City {

    private List<Building> buildings = new ArrayList<>();

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public Optional<Building> getHighestBuilding() {
        return buildings.stream()
                .max(Comparator.comparing(Building::getLevels));
    }

    public List<Building> findBuildingsByStreet(String street) {
        return buildings.stream()
                .filter(building -> building.getStreet().equals(street))
                .toList();
    }

    public Set<String> findStreetsInCity() {
        return buildings.stream()
                .map(Building::getStreet)
                .collect(Collectors.toSet());
    }

    public boolean isThereBiggerAreaInStreetThan(String street, int area) {
        return buildings.stream()
                .anyMatch(building -> building.getStreet().equals(street) && building.getArea() > area);
    }
}
