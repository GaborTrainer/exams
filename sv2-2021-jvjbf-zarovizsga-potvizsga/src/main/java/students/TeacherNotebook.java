package students;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherNotebook {

    private List<Student> students = new ArrayList<>();

    public void readFromFile(Path path) {
        try (Scanner scanner = new Scanner(path)){
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                processLines(line);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException();
        }
    }

    private void processLines(String line) {
        String[] temp = line.split(";");
        Student actualStudent = new Student(temp[0], temp[1]);
        students.add(actualStudent);
        for (int i = 2; i < temp.length; i++) {
            actualStudent.addGrade(Integer.parseInt(temp[i]));
        }
    }

    public List<String> findFailingStudents() {
        return students.stream()
                .filter(student -> student.getAverageGrade(student) < 2)
                .map(Student::getName)
                .toList();
    }

    public List<Student> getStudents() {
        return students;
    }
}
