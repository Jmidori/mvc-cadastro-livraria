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

    public void setAuthor(){
        Author author = new Author("Charlie Donlea", "norte americana");
    }

//    @Test
//    public void shouldSaveANewBook() throws SQLException {
//        setAuthor();
//
//        boolean sucess = repo.save(author);
//        Assert.isTrue(sucess, "livro salvo com sucesso");
//    }
//
//    @Test
//    public void shouldUpdateABook() throws SQLException {
//        setAuthor();
//        author.setTitle("java avancado");
//        boolean sucess = repo.update(author,1L);
//        Assert.isTrue(sucess, "livro alterado com sucesso");
//    }
//
//    @Test
//    public void shouldDeleteARegister() throws SQLException {
//        long id = 1L;
//        boolean sucess = repo.delete(id);
//        Assert.isTrue(sucess, "livro excluido com sucesso");
//    }

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
