package com.livraria.cadastrolivro.DAO;

import com.livraria.cadastrolivro.model.repository.ConnectionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {
    @Test
    public void getDBConnection() throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        Assert.notNull(connection,"Conexão aberta!");
        connection.close();
    }
}
