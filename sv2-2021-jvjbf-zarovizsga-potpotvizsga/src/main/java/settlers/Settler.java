package settlers;

public class Settler {

    public static final double YIELD_PRICE = 500;

    private int id;

    private String nameOfSettler;

    private int amountOfTobacco;

    public Settler(String nameOfSettler, int amountOfTobacco) {
        this.nameOfSettler = nameOfSettler;
        this.amountOfTobacco = amountOfTobacco;
    }

    public int getId() {
        return id;
    }

    public String getNameOfSettler() {
        return nameOfSettler;
    }

    public int getAmountOfTobacco() {
        return amountOfTobacco;
    }

    public double getExpectedIncome() {
        return YIELD_PRICE * amountOfTobacco;
    }

    public void setAmountOfTobacco(int amountOfTobacco) {
        this.amountOfTobacco = amountOfTobacco;
    }
}
