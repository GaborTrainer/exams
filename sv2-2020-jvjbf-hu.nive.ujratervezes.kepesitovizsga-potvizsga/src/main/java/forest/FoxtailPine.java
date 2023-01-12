package forest;

public class FoxtailPine extends Tree{

    private int height;

    public FoxtailPine(int height) {
        this.height = height;
    }

    public FoxtailPine() {
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
