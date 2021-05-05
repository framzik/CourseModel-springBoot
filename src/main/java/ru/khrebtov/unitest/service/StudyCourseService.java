package ru.khrebtov.unitest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.khrebtov.unitest.entity.Student;
import ru.khrebtov.unitest.entity.StudyCourse;
import ru.khrebtov.unitest.entity.dtoEntity.DtoStudyCourse;
import ru.khrebtov.unitest.repo.StudyCourseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudyCourseService implements AbstractService<DtoStudyCourse>{
    private final StudyCourseRepository studyCourseRepository;

    public StudyCourseService(StudyCourseRepository studyCourseRepository) {
        this.studyCourseRepository = studyCourseRepository;
    }

    @Override
    public List<DtoStudyCourse> findAll() {
        log.info("all StudyCourse");
        List<DtoStudyCourse> list = new ArrayList<>();
        for (StudyCourse studyCourse : studyCourseRepository.findAll()) {
            DtoStudyCourse dtoStudyCourse = getDtoStudyCourse(studyCourse);
            list.add(dtoStudyCourse);
        }
        return list;
    }

    private DtoStudyCourse getDtoStudyCourse(StudyCourse studyCourse) {
        Long studyCourseId = studyCourse.getId();
        studyCourse.setRating(studyCourseRepository.getRatings(studyCourseId));
        studyCourse.setStudent(studyCourseRepository.getStudentByStudyCourseId(studyCourseId));
        studyCourse.setCourse(studyCourseRepository.getCourseByStudyCourseId(studyCourseId));
        return new DtoStudyCourse(studyCourse);
    }

    @Override
    public DtoStudyCourse findById(Long id) {
        log.info("find studyCourse by id = {}", id);
        StudyCourse studyCourseById = studyCourseRepository.findById(id);
        return getDtoStudyCourse(studyCourseById);
    }

    @Override
    public Long count() {
        log.info("count studyCourse");
        return studyCourseRepository.count();
    }

    @Override
    public void insert(DtoStudyCourse studyCourse) {
        log.info("Try insert studyCourse with id {}", studyCourse.getId());
        if (studyCourse.getId() != null) {
            log.error("Был передан существующий studyCourse id!=null");
            throw new IllegalArgumentException();
        }
        saveOrUpdate(studyCourse);
    }

    @Override
    public void update(DtoStudyCourse studyCourse) {
        log.info("Try update professor with id {}", studyCourse.getId());
        if (studyCourse.getId() == null) {
            log.error("Был передан не существующий профессор id==null");
            throw new IllegalArgumentException();
        }
        saveOrUpdate(studyCourse);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting studyCourse with id {}", id);
        studyCourseRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdate(DtoStudyCourse studyCourse) {
        log.info("Saving studyCourse with id {}", studyCourse.getId());
        studyCourseRepository.saveOrUpdate(new StudyCourse(studyCourse));
    }
}
