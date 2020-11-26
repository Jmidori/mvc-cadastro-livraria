package com.livraria.cadastrolivro.model.repository;

import java.util.List;
import java.util.Optional;

public interface IDAO<T> {
    Optional<T> findById(Long id);
    List<T> getAll();
    boolean save(T t);
    boolean update(T t, String[] params);
    boolean delete(T t);
}
