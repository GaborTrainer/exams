package exams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultipleChoiceExamTest {

    @Test
    void createMultipleChoiceExam() {
        Exam exam = new MultipleChoiceExam(1, "Java", 90);
        Exam exam1 = new MultipleChoiceExam(2, "Java");

        assertEquals(1, exam.getStudentId());
        assertEquals("Java", exam.getTopic());
        assertEquals(90, exam.getMaxPoints());
        assertEquals(100, exam1.getMaxPoints());
    }

    @Test
    void calculateExamResultTest() {
        Exam exam = new MultipleChoiceExam(1, "Java", 50);
        exam.calculateExamResult(25);

        assertEquals(ExamResult.NOT_PASSED, exam.getExamResult());
        exam.calculateExamResult(26);
        assertEquals(ExamResult.PASSED, exam.getExamResult());

    }

    @Test
    void testCalculationWithWrongPoints() {
        Exam exam = new MultipleChoiceExam(1, "Java", 90);

        assertThrows(IllegalArgumentException.class, () -> exam.calculateExamResult(-1));
        assertThrows(IllegalArgumentException.class, () -> exam.calculateExamResult(91));
    }
}