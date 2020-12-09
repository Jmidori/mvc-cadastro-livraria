package com.livraria.cadastrolivro.model.usecase;

import com.livraria.cadastrolivro.controller.request.BookDTO;
import com.livraria.cadastrolivro.controller.request.DTO;
import com.livraria.cadastrolivro.model.dao.entity.Book;

public interface IRegisterStrategy {
    boolean validConditionForUpdate(Long id, DTO dto);

    public boolean getValidatedEntity(BookDTO book);

    Book entityBuilder(BookDTO book);

    boolean allowUpdate(long id, BookDTO book);
}
