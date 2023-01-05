package abstractions;

public interface File {

    String getFullName();

    double calculateSize();

    static final double CHANGEVALUE = 0.001;
}
