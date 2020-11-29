package com.livraria.cadastrolivro.DAO;

import com.livraria.cadastrolivro.model.entity.Category;
import com.livraria.cadastrolivro.model.repository.IDAO;
import com.livraria.cadastrolivro.model.repository.impl.CategoryDAO;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.util.List;

public class CategoryDAOTest {
    private IDAO<Category> repo = new CategoryDAO();

    @Test
    public void shouldGetARegisterById() throws SQLException {
        long id = 3L;
        Category b = (Category) repo.findById(id);
        System.out.println(b.getDescription());
        Assert.notNull(b,"categoria encontrada");
    }

    public void registerNotFondTest() throws SQLException {
        //testar qndo o livro buscado nao existe na base
    }

    @Test
    public void shouldGetAllRegisters() throws SQLException {
        List<Category> categories = repo.getAll();
        System.out.println("count = " + categories.size());
        Assert.notNull(categories, "count = " + categories.size());
    }
}
