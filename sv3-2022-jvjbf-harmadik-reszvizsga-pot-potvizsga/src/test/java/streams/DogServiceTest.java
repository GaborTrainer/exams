package streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DogServiceTest {

    DogService dogService = new DogService();

    @BeforeEach
    void init() {
        dogService.addDog(new Dog("Chuck", 7, Size.LARGE, "Labrador"));
        dogService.addDog(new Dog("Bill", 10, Size.MEDIUM, "Beagle"));
        dogService.addDog(new Dog("Caesar", 2, Size.LARGE, "Labrador"));
        dogService.addDog(new Dog("Emily", 5, Size.SMALL, "Dutch Hund"));
        dogService.addDog(new Dog("John", 8, Size.LARGE, "German Shepard"));
    }

    @Test
    void testFindDogsBySize() {
        List<Dog> result = dogService.findDogsBySize(Size.LARGE);

        assertEquals(3, result.size());
        assertEquals(List.of("Chuck", "Caesar", "John"),
                result.stream().map(Dog::getName).collect(Collectors.toList()));
    }

    @Test
    void testFindOldestDog() {
        Optional<Dog> result = dogService.findOldestDog();

        assertEquals("Bill", result.get().getName());
    }

    @Test
    void testFindDogNamesByBreedOlderThan() {
        List<String> result = dogService.findDogNamesByBreedOlderThan("Labrador", 3);
        assertEquals(List.of("Chuck"), result);

        result = dogService.findDogNamesByBreedOlderThan("Labrador", 1);
        assertEquals(List.of("Caesar", "Chuck"), result);
    }

    @Test
    void testFindDogBreeds() {
        Set<String> result = dogService.findDogBreeds();

        assertEquals(Set.of("Labrador", "Beagle", "Dutch Hund", "German Shepard"), result);
    }
}