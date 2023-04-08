package com.example.Trialbuilding.DAO;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(Long id);

    List<T> getAll();

    void save(T t);

    T update(Long id, T value) throws Exception;

    void delete(T t);
}
