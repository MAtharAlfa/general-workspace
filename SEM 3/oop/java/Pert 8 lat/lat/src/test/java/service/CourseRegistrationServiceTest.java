package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exception.DataNotFoundException;
import exception.RegistrationException;
import model.Course;
import model.Enrollment;
import model.EnrollmentStatus;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.CourseDataAccess;
import repository.EnrollmentDataAccess;
import repository.StudentDataAccess;

class CourseRegistrationServiceTest {
    private FakeStudentDataAccess students;
    private FakeCourseDataAccess courses;
    private FakeEnrollmentDataAccess enrollments;
    private CourseRegistrationService service;

    @BeforeEach
    void setUp() {
        students = new FakeStudentDataAccess();
        courses = new FakeCourseDataAccess();
        enrollments = new FakeEnrollmentDataAccess();
        service = new CourseRegistrationService(students, courses, enrollments);
        students.students.add(new Student(1, "Alice", "alice@test.com"));
        students.students.add(new Student(2, "Bob", "bob@test.com"));
        courses.courses.add(new Course("CS101", "Programming", 3, 1));
    }

    @Test
    void enrollCreatesActiveEnrollment() throws RegistrationException {
        service.enrollCourse(1, "CS101");

        assertEquals(1, enrollments.items.size());
        assertEquals(EnrollmentStatus.ACTIVE, enrollments.items.get(0).getStatus());
    }

    @Test
    void rejectsMissingDataDuplicateAndFullCourse() throws RegistrationException {
        assertThrows(RegistrationException.class, () -> service.enrollCourse(99, "CS101"));
        assertThrows(RegistrationException.class, () -> service.enrollCourse(1, "CS404"));

        service.enrollCourse(1, "CS101");
        assertThrows(RegistrationException.class, () -> service.enrollCourse(1, "CS101"));
        assertThrows(RegistrationException.class, () -> service.enrollCourse(2, "CS101"));
    }

    @Test
    void dropChangesStatusAndFreesCapacity() throws RegistrationException {
        enrollments.items.add(new Enrollment(
                1, 1, "CS101", LocalDateTime.now(), EnrollmentStatus.ACTIVE));

        service.dropCourse(1, "CS101");

        assertEquals(EnrollmentStatus.DROPPED, enrollments.items.get(0).getStatus());
        assertTrue(enrollments.findActiveByStudentAndCourse(1, "CS101").isEmpty());
    }

    @Test
    void rejectsDropWithoutActiveEnrollment() {
        assertThrows(RegistrationException.class, () -> service.dropCourse(1, "CS101"));
    }

    private static class FakeStudentDataAccess implements StudentDataAccess {
        private final List<Student> students = new ArrayList<>();

        @Override
        public Optional<Student> getById(int id) {
            for (Student student : students) {
                if (student.getId() == id) {
                    return Optional.of(student);
                }
            }
            return Optional.empty();
        }
    }

    private static class FakeCourseDataAccess implements CourseDataAccess {
        private final List<Course> courses = new ArrayList<>();

        @Override
        public Optional<Course> getByCode(String code) {
            for (Course course : courses) {
                if (course.getCode().equals(code)) {
                    return Optional.of(course);
                }
            }
            return Optional.empty();
        }
    }

    private static class FakeEnrollmentDataAccess implements EnrollmentDataAccess {
        private final List<Enrollment> items = new ArrayList<>();

        @Override
        public Optional<Enrollment> findActiveByStudentAndCourse(int studentId, String courseCode) {
            for (Enrollment enrollment : items) {
                if (enrollment.getStudentId() == studentId
                        && enrollment.getCourseCode().equals(courseCode)
                        && enrollment.getStatus() == EnrollmentStatus.ACTIVE) {
                    return Optional.of(enrollment);
                }
            }
            return Optional.empty();
        }

        @Override
        public long countActiveByCourse(String courseCode) {
            long count = 0;
            for (Enrollment enrollment : items) {
                if (enrollment.getCourseCode().equals(courseCode)
                        && enrollment.getStatus() == EnrollmentStatus.ACTIVE) {
                    count++;
                }
            }
            return count;
        }

        @Override
        public void insert(Enrollment enrollment) {
            items.add(enrollment);
        }

        @Override
        public void update(Enrollment enrollment) throws DataNotFoundException {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getId() == enrollment.getId()) {
                    items.set(i, enrollment);
                    return;
                }
            }
            throw new DataNotFoundException("Enrollment tidak ditemukan");
        }
    }
}
