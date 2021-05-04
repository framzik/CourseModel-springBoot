package ru.khrebtov.unitest.service;

import java.util.List;

public interface AbstractService<T> {
    List<T> findAll();

    T findById(Long id);

    Long count();

    void insert(T professor);

    void update(T professor);

    void deleteById(Long id);

    void saveOrUpdate(T professor);
}
