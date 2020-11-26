package com.livraria.cadastrolivro.model.repository.impl;

import com.livraria.cadastrolivro.model.entity.Category;
import com.livraria.cadastrolivro.model.repository.ConnectionFactory;
import com.livraria.cadastrolivro.model.repository.IDAO;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class CategoryDAO implements IDAO<Category> {
    private Category category;
    private Connection connection;

    public CategoryDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override

    public List<Category> getAll() {
        return null;
    }

    @Override
    public boolean save(Category category) {
        return true;

    }

    @Override
    public boolean update(Category category, String[] params) {
        return true;

    }

    @Override
    public boolean delete(Category category) {
        return true;
    }
}
