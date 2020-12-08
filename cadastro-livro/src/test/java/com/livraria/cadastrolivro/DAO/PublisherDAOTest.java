package com.livraria.cadastrolivro.DAO;

import com.livraria.cadastrolivro.model.dao.entity.Publisher;
import com.livraria.cadastrolivro.model.dao.IDAO;
import com.livraria.cadastrolivro.model.dao.impl.PublisherDAO;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.util.List;

public class PublisherDAOTest {
    private IDAO repo = new PublisherDAO();

    @Test
    public void shouldGetARegisterById() throws SQLException {
        long id = 3L;
        Publisher b = (Publisher) repo.findById(id);
        Assert.notNull(b,"editora encontrada - "+b.getName());
    }

    @Test
    public void shouldGetAllRegisters() throws SQLException {
        List<Publisher> publishers = repo.getAll();
        Assert.notNull(publishers, "count = " + publishers.size());
    }
}
