package streams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void createDog() {
        Dog dog = new Dog("Chuck", 8, Size.LARGE, "Labrador");

        assertEquals("Chuck", dog.getName());
        assertEquals(8, dog.getAge());
        assertEquals(Size.LARGE, dog.getSize());
        assertEquals("Labrador", dog.getBreed());
    }
}