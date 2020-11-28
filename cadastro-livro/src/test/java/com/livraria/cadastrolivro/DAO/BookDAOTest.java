package com.livraria.cadastrolivro.DAO;

import com.livraria.cadastrolivro.model.entity.Book;
import com.livraria.cadastrolivro.model.repository.IDAO;
import com.livraria.cadastrolivro.model.repository.impl.BookDAO;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.time.LocalDate;

public class BookDAOTest {
    private Book book;
    private IDAO bookRepo = new BookDAO();

    public void setBook(){
        this.book = new Book("9788533302273", "java basico", 1L, 2L, 3, LocalDate.now(), 1, true);
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

}
