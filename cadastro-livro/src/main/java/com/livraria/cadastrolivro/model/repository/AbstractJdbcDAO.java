package com.livraria.cadastrolivro.model.repository;

import java.sql.Connection;

public abstract class AbstractJdbcDAO implements IDAO {
    protected Connection connection;
    protected String table;
    protected String idTable;
    protected boolean ctrlTransaction;

    protected void openConnection(){

    }

}
