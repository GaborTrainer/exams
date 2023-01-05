package streams;

import java.util.*;
import java.util.stream.Collectors;

public class DogService {

    private List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public List<Dog> findDogsBySize(Size size) {
        return dogs.stream()
                .filter(dog -> dog.getSize().equals(size))
                .toList();
    }

    public Optional<Dog> findOldestDog() {
        return dogs.stream()
                .max(Comparator.comparingInt(Dog::getAge));
    }


    public List<String> findDogNamesByBreedOlderThan(String breed, int age) {
        return dogs.stream()
                .filter(dog -> dog.getBreed().equals(breed) && dog.getAge() > age)
                .map(Dog::getName)
                .sorted()
                .toList();
    }

    public Set<String> findDogBreeds() {
        return dogs.stream()
                .map(Dog::getBreed)
                .collect(Collectors.toSet());
    }
}
