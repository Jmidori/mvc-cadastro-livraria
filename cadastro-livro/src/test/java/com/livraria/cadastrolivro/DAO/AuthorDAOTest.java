package com.livraria.cadastrolivro.DAO;

import com.livraria.cadastrolivro.model.entity.Author;
import com.livraria.cadastrolivro.model.entity.Book;
import com.livraria.cadastrolivro.model.repository.IDAO;
import com.livraria.cadastrolivro.model.repository.impl.AuthorDAO;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.util.List;

public class AuthorDAOTest {
    private IDAO repo = new AuthorDAO();

    @Test
    public void shouldGetARegisterById() throws SQLException {
        long id = 3L;
        Author b = (Author) repo.findById(id);
        System.out.println(b.getName());
        Assert.notNull(b,"autor encontrado - "+b.getName());
    }

    public void registerNotFondTest() throws SQLException {
        //testar qndo o livro buscado nao existe na base
    }

    @Test
    public void shouldGetAllRegisters() throws SQLException {
        List<Book> books = repo.getAll();
        Assert.notNull(books, "count = " + books.size());
    }
}
