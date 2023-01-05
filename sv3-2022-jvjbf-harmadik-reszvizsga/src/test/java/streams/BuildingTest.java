package streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BuildingTest {

    @Test
    void testCreateBuilding() {
        Building b = new Building("Kossuth", 123, 2);

        Assertions.assertEquals("Kossuth", b.getStreet());
        Assertions.assertEquals(123, b.getArea());
        Assertions.assertEquals(2, b.getLevels());
    }
}