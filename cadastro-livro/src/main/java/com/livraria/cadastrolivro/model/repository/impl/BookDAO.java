package com.livraria.cadastrolivro.model.repository.impl;

import com.livraria.cadastrolivro.model.entity.Book;
import com.livraria.cadastrolivro.model.repository.ConnectionFactory;
import com.livraria.cadastrolivro.model.repository.IDAO;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    private static final String COLUM_CATEGORY= "categoria";
    private static final String COLUM_BEST_SELLER= "bestSeller";

    public BookDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public Book findById(Long id) {
        String query = "SELECT * FROM "+ TABLE_NAME + " WHERE ID=?";
        Book book = new Book();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            rs.next();

            book.setIsbn(rs.getString(COLUM_ISBN));
            book.setTitle(rs.getString(COLUM_TITLE));
            book.setAuthorId(rs.getLong(COLUM_AUTHOR));
            book.setPublisherId(rs.getLong(COLUM_PUBLISHER));
            book.setEdition(rs.getInt(COLUM_EDITION));
            book.setPublicationDate(rs.getDate(COLUM_PUBLICATION_DATE).toLocalDate());
            book.setCategoryId(rs.getInt(COLUM_CATEGORY));
            book.setBestSeller(rs.getBoolean(COLUM_BEST_SELLER));

            rs.close();
            statement.close();
            if(Objects.isNull(book)) {
                System.out.format("Livro de id %d não foi encontrado.", id);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao tentar excluir o livro de id " + id);
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> getAll() {
        String query = "SELECT * FROM "+ TABLE_NAME;
        List<Book> books = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getString(COLUM_ISBN));
                book.setTitle(rs.getString(COLUM_TITLE));
                book.setAuthorId(rs.getLong(COLUM_AUTHOR));
                book.setPublisherId(rs.getLong(COLUM_PUBLISHER));
                book.setEdition(rs.getInt(COLUM_EDITION));
                book.setPublicationDate(rs.getDate(COLUM_PUBLICATION_DATE).toLocalDate());
                book.setCategoryId(rs.getInt(COLUM_CATEGORY));
                book.setBestSeller(rs.getBoolean(COLUM_BEST_SELLER));

                books.add(book);
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Erro ao tentar buscar os registros de livros na base de dados");
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public boolean save(Book book) {
        String query = "INSERT INTO "+ TABLE_NAME + " (" + COLUM_ISBN + ", " +
                                                            COLUM_TITLE + ", " +
                                                            COLUM_AUTHOR + ", " +
                                                            COLUM_PUBLISHER + ", " +
                                                            COLUM_EDITION + ", " +
                                                            COLUM_PUBLICATION_DATE + ", " +
                                                            COLUM_CATEGORY + ", " +
                                                            COLUM_BEST_SELLER + ") VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setLong(3, book.getAuthorId());
            statement.setLong(4, book.getPublisherId());
            statement.setInt(5, book.getEdition());
            statement.setDate(6, Date.valueOf(book.getPublicationDate()));
            statement.setInt(7, book.getCategoryId());
            statement.setBoolean(8, book.getBestSeller());

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
    public boolean update(Book book, Long id) {
        String query = "UPDATE "+ TABLE_NAME + " SET " + COLUM_ISBN + "=?, " +
                COLUM_TITLE + "=?, " +
                COLUM_AUTHOR + "=?, " +
                COLUM_PUBLISHER + "=?, " +
                COLUM_EDITION + "=?, " +
                COLUM_PUBLICATION_DATE + "=?, " +
                COLUM_CATEGORY + "=?, " +
                COLUM_BEST_SELLER + "=? WHERE id=?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setLong(3, book.getAuthorId());
            statement.setLong(4, book.getPublisherId());
            statement.setInt(5, book.getEdition());
            statement.setDate(6, Date.valueOf(book.getPublicationDate()));
            statement.setInt(7, book.getCategoryId());
            statement.setBoolean(8, book.getBestSeller());
            statement.setLong(9, id);

            statement.execute();
            statement.close();
            return true;

        } catch (SQLException throwables) {
            System.out.println("Erro ao tentar atualizar o livro " + book.getTitle());
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
            System.out.println("Erro ao tentar excluir o livro de id " + id);
            throwables.printStackTrace();
        }
        return false;
    }
}
