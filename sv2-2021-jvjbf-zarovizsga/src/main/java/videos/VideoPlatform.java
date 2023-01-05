package videos;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VideoPlatform {

    private List<Channel> channels = new ArrayList<>();

    public List<Channel> getChannels() {
        return channels;
    }

    public void readDataFromFile(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            String[] firstLine = scanner.nextLine().split(" ");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                processLine(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot open file for read!");
        }
    }

    private void processLine(String line) {
        String[] temp = line.split(";");
        channels.add(new Channel(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
    }

    public int calculateSumOfVideos() {
        return channels.stream()
                .mapToInt(Channel::getNumber_of_videos)
                .sum();
    }
}
