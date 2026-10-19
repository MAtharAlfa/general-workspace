package service;

import exception.RegistrationException;
import repository.CourseDataAccess;
import repository.EnrollmentDataAccess;
import repository.StudentDataAccess;

public class CourseRegistrationService {
    private final StudentDataAccess studentRepository;
    private final CourseDataAccess courseRepository;
    private final EnrollmentDataAccess enrollmentRepository;

    public CourseRegistrationService(StudentDataAccess studentRepository,
                                    CourseDataAccess courseRepository,
                                    EnrollmentDataAccess enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public void enrollCourse(int studentId, String courseCode) throws RegistrationException {
        // 1. Pastikan student ada (studentRepository.getById), jika tidak -> RegistrationException.
        // 2. Pastikan course ada (courseRepository.getByCode), jika tidak -> RegistrationException.
        // 3. Tolak jika student sudah punya enrollment ACTIVE pada course tsb
        //    (enrollmentRepository.findActiveByStudentAndCourse).
        // 4. Tolak jika enrollmentRepository.countActiveByCourse >= course.getClassCapacity().
        // 5. Simpan: enrollmentRepository.insert(
        //        new Enrollment(0, studentId, courseCode, LocalDateTime.now(), EnrollmentStatus.ACTIVE));
        //    (id 0 diabaikan, kolom id diisi AUTO_INCREMENT oleh database)
        throw new UnsupportedOperationException("TODO: enrollCourse");
    }

    public void dropCourse(int studentId, String courseCode) throws RegistrationException {
        // 1. Pastikan student dan course ada (sama seperti enrollCourse).
        // 2. Cari enrollment ACTIVE (findActiveByStudentAndCourse), jika tidak ada -> RegistrationException.
        // 3. Ubah status menjadi EnrollmentStatus.DROPPED lalu enrollmentRepository.update(enrollment).
        //    Catatan: update() melempar DataNotFoundException (checked), tangani di sini.
        throw new UnsupportedOperationException("TODO: dropCourse");
    }
}