package com.livraria.cadastrolivro.model.repository.impl;

import com.livraria.cadastrolivro.model.entity.Author;
import com.livraria.cadastrolivro.model.repository.ConnectionFactory;
import com.livraria.cadastrolivro.model.repository.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuthorDAO implements IDAO<Author> {
    private Connection connection;
    private static final String TABLE_NAME = "autor";
    private static final String COLUM_ID = "id";
    private static final String COLUM_NAME = "nome";
    private static final String COLUM_NACIONALITY = "nacionalidade";

    public AuthorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public Author findById(Long id) {
        String query = "SELECT * FROM "+ TABLE_NAME + " WHERE ID=?";
        Author author = new Author();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();

            author.setId(rs.getLong(COLUM_ID));
            author.setName(rs.getString(COLUM_NAME));
            author.setNationality(rs.getString(COLUM_NACIONALITY));

            rs.close();
            statement.close();
            if(Objects.isNull(author)) {
                System.out.format("Autor de id %d não foi encontrado.", id);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao tentar buscar o autor de id " + id);
            e.printStackTrace();
        }
        return author;
    }

    @Override
    public List<Author> getAll() {
        String query = "SELECT * FROM "+ TABLE_NAME;
        List<Author> authors = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Author author = new Author();
                author.setId(rs.getLong(COLUM_ID));
                author.setName(rs.getString(COLUM_NAME));
                author.setNationality(rs.getString(COLUM_NACIONALITY));

                authors.add(author);
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.format("Erro ao tentar buscar os registros de %s da tabela ",TABLE_NAME);
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public boolean save(Author author) {
        String query = "INSERT INTO "+ TABLE_NAME + " (" + COLUM_NAME + ", " 
                + COLUM_NACIONALITY + ") VALUES (?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, author.getName());
            statement.setString(2, author.getNationality());

            statement.execute();
            statement.close();
            return true;

        } catch (SQLException throwables) {
            System.out.println("Erro ao tentar adicionar o autor " + author.getName());
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Author o, Long id) {
        String query = "UPDATE "+ TABLE_NAME + " SET " +
                COLUM_NAME + "=?, " +
                COLUM_NACIONALITY + "=? WHERE id=?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, o.getName());
            statement.setString(2, o.getNationality());
            statement.setLong(3, id);

            statement.execute();
            statement.close();
            return true;

        } catch (SQLException throwables) {
            System.out.println("Erro ao tentar atualizar o autor " + o.getName());
            throwables.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean delete(Long id) {
        String query = "DELETE FROM "+ TABLE_NAME + " WHERE ID=?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);

            statement.execute();
            statement.close();
            return true;

        } catch (SQLException throwables) {
            System.out.println("Erro ao tentar excluir o autor de id " + id);
            throwables.printStackTrace();
        }
        return false;
    }
}
