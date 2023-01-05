package videos;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private List<Video> videos = new ArrayList<>();

    public User(String userName) {
        this.userName = userName;
    }

    public void uploadVideo(Video video) {
        videos.add(video);
    }

    public int countVideosByType(Type type) {
//        int count = 0;
//        for (Video video : videos) {
//            if (video.getType() == type) {
//                count++;
//            }
//        }
//        return count;
        return (int) videos.stream()
                .filter(video -> video.getType().equals(type))
                .count();
    }

    public int sumOfViews() {
//        int sum = 0;
//        for (Video video : videos) {
//            sum += video.getViews();
//        }
//        return sum;
        return videos.stream()
                .mapToInt(Video::getViews)
                .sum();
    }

    public String getUserName() {
        return userName;
    }

    public List<Video> getVideos() {
        return new ArrayList<>(videos);
    }
}
