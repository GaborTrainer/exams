package abstractions;

public class Advertisement implements Content {

    private String title;

    public Advertisement(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getImportance() {
        return 1;
    }
}
