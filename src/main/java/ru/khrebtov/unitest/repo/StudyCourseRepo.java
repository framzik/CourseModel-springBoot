package ru.khrebtov.unitest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.khrebtov.unitest.entity.Course;
import ru.khrebtov.unitest.entity.Student;
import ru.khrebtov.unitest.entity.StudyCourse;

import java.util.List;

public interface StudyCourseRepo extends JpaRepository<StudyCourse, Long> {

    @Query("select r.rating from Rating r where r.studyCourseId=?1")
    List<Integer> getRatings(Long id);

    @Query("select s from Student s left join StudyCourse sc on s.id=sc.student.id where sc.id = ?1")
    Student getStudentByStudyCourseId(Long id);

    @Query("select c from Course c left join StudyCourse sc on c.id=sc.course.id where sc.id = ?1")
    Course getCourseByStudyCourseId(Long id);

    @Query("select 1.0*sum(r.rating)/count(r) from Rating r where r.studyCourseId=?1")
    Double getAverageRating(Long id);
}
