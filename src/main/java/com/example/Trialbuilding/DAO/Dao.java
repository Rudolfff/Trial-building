package com.example.Trialbuilding.DAO;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(Long id);

    List<T> getAll();

    T save(T t);

    T update(Long id, T value) throws Exception;

    T delete(Long id) throws Exception;
}
