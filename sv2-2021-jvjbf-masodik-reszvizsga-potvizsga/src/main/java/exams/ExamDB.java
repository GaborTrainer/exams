package exams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExamDB {

    private List<Exam> exams = new ArrayList<>();

    public void addExam(Exam exam, int score) {
        exam.calculateExamResult(score);
        exams.add(exam);
    }

    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }

    public int countPassedExams() {
        return exams.stream()
                .filter(e -> !e.getExamResult().equals(ExamResult.NOT_PASSED))
                .toList()
                .size();
    }

    public List<Exam> findById(int id) {
        return exams.stream()
                .filter(e -> e.getStudentId() == id)
                .toList();
    }

    public List<String> findTopicByPrefix(String prefix) {
        return exams.stream()
                .map(Exam::getTopic)
                .filter(topic -> topic.startsWith(prefix))
                .collect(Collectors.toSet())
                .stream().toList();
    }
}
