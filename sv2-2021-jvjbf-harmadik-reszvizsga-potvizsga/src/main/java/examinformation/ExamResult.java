package examinformation;

public class ExamResult {

    private int theory;

    private int practice;

    public ExamResult(int theory, int practice) {
        this.theory = theory;
        this.practice = practice;
    }

    public int getPractice() {
        return practice;
    }

    public int getTheory() {
        return theory;
    }

    public int getMaxPoints() {
        return theory + practice;
    }
}
