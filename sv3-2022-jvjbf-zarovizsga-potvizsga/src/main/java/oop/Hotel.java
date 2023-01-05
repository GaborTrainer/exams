package oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Hotel {

    private Set<Apartment> rooms;

    public Hotel(Set<Apartment> rooms) {
        this.rooms = rooms;
    }

    public void readBookings(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                int bookedForPeople = Integer.parseInt(line);
                findRoomForPeople(bookedForPeople);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot reach file!", e);
        }
    }

    public List<Integer> getFreeRoomNumbers() {
        return rooms.stream()
                .filter(Apartment::isFree)
                .map(Apartment::getRoomNumber)
                .collect(Collectors.toList());
    }

    private void findRoomForPeople(int numberOfPeople) {
        Apartment apartment = rooms.stream()
                .sorted(Comparator.comparing(Apartment::getPeopleCanFit))
                .filter(Apartment::isFree)
                .filter(h -> h.getPeopleCanFit() >= numberOfPeople)
                .findFirst().orElseThrow(() -> new IllegalStateException("No room for people!"));
        apartment.rent();
    }

    public Set<Apartment> getRooms() {
        return rooms;
    }
}