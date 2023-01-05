package abstractions;

public class Movie implements Content {

    private Video video;

    public Movie(Video video) {
        this.video = video;
    }

    @Override
    public String getTitle() {
        return video.getTitle();
    }

    @Override
    public int getLength() {
        return video.getLength();
    }

    @Override
    public void addVideo(Video video) {
        throw new IllegalStateException("Cannot add more video for this type of content!");
    }
}
