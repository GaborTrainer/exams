package streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    City city = new City();

    @BeforeEach
    void init() {
        city.addBuilding(new Building("Kossuth", 120, 2));
        city.addBuilding(new Building("Petofi", 80, 1));
        city.addBuilding(new Building("Petofi", 160, 9));
        city.addBuilding(new Building("Kossuth", 32, 0));
        city.addBuilding(new Building("Petofi", 86, 3));
        city.addBuilding(new Building("Kossuth", 121, 1));
    }

    @Test
    void testFindHighestBuilding() {
        Optional<Building> result = city.getHighestBuilding();

        assertTrue(result.isPresent());
        Assertions.assertEquals(9, result.get().getLevels());
    }

    @Test
    void testFindBuildingsByStreet() {
        List<Building> result = city.findBuildingsByStreet("Kossuth");

        assertEquals(3, result.size());
        Assertions.assertEquals(120, result.get(0).getArea());
    }

    @Test
    void testFindBuildingsByStreetEmptyList() {
        List<Building> result = city.findBuildingsByStreet("Deak");

        assertEquals(0, result.size());
    }

    @Test
    void testFindStreetsInCity() {
        Set<String> result = city.findStreetsInCity();

        assertEquals(2, result.size());
        assertTrue(result.contains("Kossuth"));
        assertTrue(result.contains("Petofi"));
    }

    @Test
    void testIsThereBiggerAreaThanInStreet() {
        Assertions.assertTrue(city.isThereBiggerAreaInStreetThan("Petofi", 159));
        Assertions.assertFalse(city.isThereBiggerAreaInStreetThan("Kossuth", 160));
    }
}