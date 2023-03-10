package exams;

public class MultipleChoiceExam extends Exam {

    public static final double PASSING_PERCENT = 51.0;

    protected MultipleChoiceExam(long studentId, String topic) {
        super(studentId, topic);
    }

    protected MultipleChoiceExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        new ActualPointValidator().checkActualPoint(actualPoints, getMaxPoints());
        if (actualPoints / (getMaxPoints() / 100.0) >= PASSING_PERCENT) {
            setExamResult(ExamResult.PASSED);
        } else {
            setExamResult(ExamResult.NOT_PASSED);
        }
    }
}
