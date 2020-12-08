package com.livraria.cadastrolivro.DAO;

import com.livraria.cadastrolivro.model.dao.entity.Book;
import com.livraria.cadastrolivro.model.dao.IDAO;
import com.livraria.cadastrolivro.model.dao.impl.BookDAO;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class BookDAOTest {
    private Book book;
    private IDAO bookRepo = new BookDAO();

    public void setBook(){

        this.book = new Book(null,"9788522005239", "o pequeno principe", 2L, 3L, 5, LocalDate.now(), 2, true);
//        Book book2 = new Book("9788533302273", "java avancado", 1L, 2L, 1, LocalDate.now(), 1,false);
    }

    @Test
    public void shouldSaveANewBook() throws SQLException {
        setBook();

        boolean sucess = bookRepo.save(book);
        Assert.isTrue(sucess, "livro salvo com sucesso");
    }

    @Test
    public void shouldUpdateABook() throws SQLException {
        setBook();
        book.setTitle("java avancado");
        boolean sucess = bookRepo.update(book,1L);
        Assert.isTrue(sucess, "livro alterado com sucesso");
    }

    @Test
    public void shouldDeleteARegister() throws SQLException {
        long id = 1L;
        boolean sucess = bookRepo.delete(id);
        Assert.isTrue(sucess, "livro excluido com sucesso");
    }

    @Test
    public void shouldGetARegisterById() throws SQLException {
        setBook();
        long id = 2L;
        Book b = (Book) bookRepo.findById(id);
        Assert.notNull(b,"livro encontrado - "+b.getTitle());
    }

    public void registerNotFondTest() throws SQLException {
        //testar qndo o livro buscado nao existe na base
    }

    @Test
    public void shouldGetAllRegisters() throws SQLException {
        List<Book> books = bookRepo.getAll();
        Assert.notNull(books, "count = " + books.size());
    }
}
