package com.livraria.cadastrolivro.model.usecase;

import com.livraria.cadastrolivro.controller.BooKDTO;
import com.livraria.cadastrolivro.model.dao.entity.Book;

public interface IBookUsecase {
    public boolean getValidatedEntity(BooKDTO book);

    Book entityBuilder(BooKDTO book);

    boolean allowUpdate(long id, BooKDTO book);
}
