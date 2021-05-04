package ru.khrebtov.unitest.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.khrebtov.unitest.entity.Course;
import ru.khrebtov.unitest.entity.Professor;

import java.util.List;

@Repository
public class ProfessorRepository {
    private final ProfessorRepo professorRepo;

    @Autowired
    public ProfessorRepository(ProfessorRepo professorRepo) {
        this.professorRepo = professorRepo;
    }

    public List<Professor> findAll() {
        return professorRepo.findAll();
    }

    public Professor findById(Long id){
        return professorRepo.findById(id).orElse(null);
    }

    public Long count(){
        return professorRepo.count();
    }

    public void saveOrUpdate(Professor professor) {
        professorRepo.save(professor);
    }

    public void deleteById(Long id) {
        professorRepo.deleteById(id);
    }

    public List<Course> getProfessorsCourses(Long professorsId){
       return professorRepo.getProfessorsCourses(professorsId);
    }
}
