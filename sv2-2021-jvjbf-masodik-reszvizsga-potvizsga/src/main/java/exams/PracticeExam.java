package exams;

import java.util.List;

public class PracticeExam extends Exam {

    public static final double PASSING_PERCENT = 51.0;

    public static final double PERFECT_PERCENT = 76.0;

    private final List<Integer> score;

    public PracticeExam(long studentId, String topic, List<Integer> score) {
        super(studentId, topic);
        this.score = score;
        int maxPoints = calculateMaxPointsWithList();
        if (maxPoints < 10 || maxPoints > 150) {
            throw new IllegalArgumentException("Maximum points should be between 10 and 150! Actual: " + maxPoints);
        }
        setMaxPoints(calculateMaxPointsWithList());
    }

    private int calculateMaxPointsWithList() {
       return score.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    protected void calculateExamResult(int actualPoints) {
        new ActualPointValidator().checkActualPoint(actualPoints, getMaxPoints());
        if (actualPoints / (getMaxPoints() / 100.0) >= PASSING_PERCENT) {
            setExamResult(ExamResult.OK);
        } else if (actualPoints / (getMaxPoints() / 100.0) >= PERFECT_PERCENT) {
            setExamResult(ExamResult.PERFECT);
        } else {
            setExamResult(ExamResult.NOT_PASSED);
        }
    }
}
