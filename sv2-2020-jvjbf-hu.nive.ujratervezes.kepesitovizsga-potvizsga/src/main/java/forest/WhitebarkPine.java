package forest;

public class WhitebarkPine extends Tree {

    private int height;

    public WhitebarkPine(int height) {
        this.height = height;
    }

    public WhitebarkPine() {
    }

    @Override
    public void irrigate() {
        height += 2;
        super.irrigate();
    }

    @Override
    public int getHeight() {
        return height;
    }
}
