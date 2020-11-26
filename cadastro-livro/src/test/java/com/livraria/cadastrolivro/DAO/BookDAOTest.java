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

    public void setBook(){
        this.book = new Book("9788533302273", "java basico", 1L, 2L, 3, LocalDate.now(), 1L, true);
    }

    @Test
    public void shouldSaveANewBook() throws SQLException {
        setBook();
        IDAO bookRepo = new BookDAO();

        boolean sucess = bookRepo.save(book);
        Assert.isTrue(sucess, "livro salvo com sucesso");
    }

}
