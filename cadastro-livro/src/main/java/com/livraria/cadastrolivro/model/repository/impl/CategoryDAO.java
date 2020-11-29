package com.livraria.cadastrolivro.model.repository.impl;

import com.livraria.cadastrolivro.model.entity.Category;
import com.livraria.cadastrolivro.model.repository.ConnectionFactory;
import com.livraria.cadastrolivro.model.repository.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CategoryDAO implements IDAO<Category> {
    private Connection connection;
    private static final String TABLE_NAME = "categoria";
    private static final String COLUM_ID = "id";
    private static final String COLUM_DESCRIPTION = "descricao";

    public CategoryDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public Category findById(Long id) {
        String query = "SELECT * FROM "+ TABLE_NAME + " WHERE ID=?";
        Category category = new Category();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();

            category.setId(rs.getLong(COLUM_ID));
            category.setDescription(rs.getString(COLUM_DESCRIPTION));

            rs.close();
            statement.close();
            if(Objects.isNull(category)) {
                System.out.format("Categoria de id %d não foi encontrado.", id);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao tentar buscar a categoria de id " + id);
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> getAll() {
        String query = "SELECT * FROM "+ TABLE_NAME;
        List<Category> categories = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                ;
                categories.add(this.categoryBuilder(rs));
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.format("Erro ao tentar buscar os registros de %s da tabela ",TABLE_NAME);
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public boolean save(Category category) {
        System.out.format("Implementacao nao contemplada nessa versao. A operacao deve ser feita atraves do banco de dados");
        return false;
    }

    @Override
    public boolean update(Category category, Long id) {
        System.out.format("Implementacao nao contemplada nessa versao. A operacao deve ser feita atraves do banco de dados");
        return false;
    }

    @Override
    public boolean delete(Long id) {
        System.out.format("Implementacao nao contemplada nessa versao. A operacao deve ser feita atraves do banco de dados");
        return false;
    }

    private Category categoryBuilder(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setId(rs.getLong(COLUM_ID));
        category.setDescription(rs.getString(COLUM_DESCRIPTION));

        return category;
    }
}
