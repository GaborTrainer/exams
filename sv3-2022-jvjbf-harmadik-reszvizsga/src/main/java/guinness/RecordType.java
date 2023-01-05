package guinness;

public enum RecordType {

    TIME("s"), QUANTITY ("quantity unit");

    private String measure;

    RecordType(String measure) {
        this.measure = measure;
    }

    public String getMeasure() {
        return measure;
    }
}
