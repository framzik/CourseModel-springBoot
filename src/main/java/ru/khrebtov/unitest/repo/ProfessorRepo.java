package ru.khrebtov.unitest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.khrebtov.unitest.entity.Course;
import ru.khrebtov.unitest.entity.Professor;

import java.util.List;

public interface ProfessorRepo extends JpaRepository<Professor, Long> {
    @Query("select c from Course c left join CourseProfessor cp on c.id=cp.courseId where cp.professorsId =?1")
    List<Course> getProfessorsCourses(Long professorsId);
}
