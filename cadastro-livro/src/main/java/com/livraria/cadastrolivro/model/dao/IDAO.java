package com.livraria.cadastrolivro.model.dao;

import java.util.List;

public interface IDAO<T> {
    T findById(Long id);
    List<T> getAll();
    boolean save(T t);
    boolean update(T t, Long id);
    boolean delete(Long id);
}
