package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserFileManager {

    private List<User> users = new ArrayList<>();

    public void readUsersFromFile(Path path) {
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(this::processLine);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    private void processLine(String line) {
        String[] temp = line.split(" ");
        users.add(new User(temp[0], Integer.parseInt(temp[1]), temp[2]));
    }

    public void writeHumansToFile(Path path) {
        try {
            Files.write(path, getHumans());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private List<String> getHumans() {
        return users.stream()
                .filter(User::isEmailAndUserMatches)
                .map(User::getUserName)
                .toList();
    }

    public List<User> getUsers() {
        return users;
    }
}
