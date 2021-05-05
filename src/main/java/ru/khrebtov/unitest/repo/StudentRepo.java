package ru.khrebtov.unitest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.khrebtov.unitest.entity.Student;
import ru.khrebtov.unitest.entity.StudyCourse;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query("select sc from StudyCourse sc where sc.student.id = ?1")
    List<StudyCourse> getStudentStudyCourses(Long studentId);

}
