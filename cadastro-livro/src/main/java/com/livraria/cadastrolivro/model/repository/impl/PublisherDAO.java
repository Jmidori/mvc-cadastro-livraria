package com.livraria.cadastrolivro.model.repository.impl;

import com.livraria.cadastrolivro.model.entity.Publisher;
import com.livraria.cadastrolivro.model.repository.ConnectionFactory;
import com.livraria.cadastrolivro.model.repository.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PublisherDAO implements IDAO<Publisher> {
    private Connection connection;
    private static final String TABLE_NAME = "editora";
    private static final String COLUM_ID = "id";
    private static final String COLUM_NAME = "nome";
    private static final String COLUM_NACIONALITY = "nacionalidade";

    public PublisherDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public Publisher findById(Long id) {
        String query = "SELECT * FROM "+ TABLE_NAME + " WHERE ID=?";
        Publisher publisher = new Publisher();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();

            publisher.setId(rs.getLong(COLUM_ID));
            publisher.setName(rs.getString(COLUM_NAME));
            publisher.setNationality(rs.getString(COLUM_NACIONALITY));

            rs.close();
            statement.close();
            if(Objects.isNull(publisher)) {
                System.out.format("Editora de id %d não foi encontrado.", id);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao tentar buscar a Editora de id " + id);
            e.printStackTrace();
        }
        return publisher;
    }

    @Override
    public List<Publisher> getAll() {
        String query = "SELECT * FROM "+ TABLE_NAME;
        List<Publisher> publishers = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Publisher publisher = new Publisher();
                publisher.setId(rs.getLong(COLUM_ID));
                publisher.setName(rs.getString(COLUM_NAME));
                publisher.setNationality(rs.getString(COLUM_NACIONALITY));

                publishers.add(publisher);
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.format("Erro ao tentar buscar os registros de %s da tabela ",TABLE_NAME);
            e.printStackTrace();
        }
        return publishers;
    }

    @Override
    public boolean save(Publisher publisher) {
        System.out.format("Implementacao nao contemplada nessa versao. A operacao deve ser feita atraves do banco de dados");
        return false;

    }

    @Override
    public boolean update(Publisher publisher, Long id) {
        System.out.format("Implementacao nao contemplada nessa versao. A operacao deve ser feita atraves do banco de dados");
        return false;
    }

    @Override
    public boolean delete(Long id) {
        System.out.format("Implementacao nao contemplada nessa versao. A operacao deve ser feita atraves do banco de dados");
        return false;
    }
}
