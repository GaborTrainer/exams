package datahandling;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    public void saveAnimals(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            String[] firstLine = scanner.nextLine().split(" ");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                processLine(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot reach file!");
        }
    }

    private void processLine(String line) {
        String[] temp = line.split(";");
        Animal animal = new Animal(temp[0], Integer.parseInt(temp[1]), LocalDate.parse(temp[2]));
        animalRepository.saveAnimal(animal);
    }


    public List<Animal> findAllAnimals() {
        return animalRepository.findAllAnimals();
    }


    public int countAllByAnimalType(String species) {
        return animalRepository.countAllByAnimalType(species);
    }
}
