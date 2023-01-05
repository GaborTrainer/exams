package abstractions;

public class Picture  implements File {

    private String title;

    private String extension;

    private int width;

    private int length;

    public Picture(String title, String extension, int width, int length) {
        this.title = title;
        this.extension = extension;
        this.width = width;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public String getExtension() {
        return extension;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getFullName() {
        return title + ".jpg";
    }

    @Override
    public double calculateSize() {
        return (getLength() * getWidth()) * CHANGEVALUE;
    }
}
