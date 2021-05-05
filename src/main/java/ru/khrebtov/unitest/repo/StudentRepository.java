package ru.khrebtov.unitest.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.khrebtov.unitest.entity.Course;
import ru.khrebtov.unitest.entity.Student;
import ru.khrebtov.unitest.entity.StudyCourse;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class StudentRepository {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentRepository(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public Student findById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Long count() {
        return studentRepo.count();
    }

    public void saveOrUpdate(Student student) {
        studentRepo.save(student);
    }

    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    public List<StudyCourse> getStudentStudyCourses(Long studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("Передан  не существующий студент (id=null)");
        }
        return studentRepo.getStudentStudyCourses(studentId);
    }

    public List<Course> getStudentCourses(Long studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("Передан  не существующий студент (id=null)");
        }
        return studentRepo.getStudentCourses(studentId);
    }
}
