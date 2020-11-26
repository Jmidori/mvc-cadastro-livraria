package com.livraria.cadastrolivro.model.repository.impl;

import com.livraria.cadastrolivro.model.entity.Book;
import com.livraria.cadastrolivro.model.repository.ConnectionFactory;
import com.livraria.cadastrolivro.model.repository.IDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookDAO implements IDAO<Book> {

    private Connection connection;
    private static final String TABLE_NAME = "livro";
    private static final String COLUM_ISBN= "isbn";
    private static final String COLUM_TITLE= "titulo";
    private static final String COLUM_AUTHOR= "autor";
    private static final String COLUM_PUBLISHER= "editora";
    private static final String COLUM_EDITION= "volume";
    private static final String COLUM_PUBLICATION_DATE= "dataLancamento";
    private static final String COLUM_BEST_SELLER= "bestSeller";

    public BookDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public boolean save(Book book) {
        String query = "INSERT INTO "+ TABLE_NAME + " (" + COLUM_ISBN + ", " +
                                                            COLUM_TITLE + ", " +
                                                            COLUM_AUTHOR + ", " +
                                                            COLUM_PUBLISHER + ", " +
                                                            COLUM_EDITION + ", " +
                                                            COLUM_PUBLICATION_DATE + ", " +
                                                            COLUM_BEST_SELLER + ") VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setLong(3, book.getAuthorId());
            statement.setLong(4, book.getPublisherId());
            statement.setInt(5, book.getEdition());
            statement.setDate(6, Date.valueOf(book.getPublicationDate()));
            statement.setBoolean(7, book.getBestSeller());

            statement.execute();
            statement.close();
            return true;

        } catch (SQLException throwables) {
            System.out.println("Erro ao tentar adicionar o livro " + book.getTitle());
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Book book, String[] params) {
        return true;

    }

    @Override
    public boolean delete(Book book) {
        return true;

    }
}
