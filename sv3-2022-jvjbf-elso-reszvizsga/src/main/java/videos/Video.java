package videos;

import java.time.LocalDate;

public class Video {

    private String title;
    private LocalDate uploadTime;
    private int length;
    private Type type;
    private int views;

    public Video(String title, LocalDate uploadTime, int length, Type type) {
        this.title = title;
        this.uploadTime = uploadTime;
        this.length = length;
        this.type = type;
    }

    public void watchVideo() {
        views++;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getUploadTime() {
        return uploadTime;
    }

    public int getLength() {
        return length;
    }

    public Type getType() {
        return type;
    }

    public int getViews() {
        return views;
    }
}
