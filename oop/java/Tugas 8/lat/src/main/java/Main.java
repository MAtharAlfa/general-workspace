import java.util.List;

import model.Student;
import repository.StudentRepository;

public class Main {
    public static void main(String[] args) {
        StudentRepository repo = new StudentRepository();
        

        List<Student> students = repo.getAll();

        if (!students.isEmpty()) {
                System.out.println("Hasil Query:");
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }

        System.out.println("OK");
    }
}
