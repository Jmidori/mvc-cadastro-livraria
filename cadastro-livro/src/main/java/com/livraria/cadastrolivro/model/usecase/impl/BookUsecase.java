package com.livraria.cadastrolivro.model.usecase.impl;

import com.livraria.cadastrolivro.controller.BooKDTO;
import com.livraria.cadastrolivro.model.entity.Book;
import com.livraria.cadastrolivro.model.repository.impl.BookDAO;
import com.livraria.cadastrolivro.model.usecase.IBookUsecase;

import javax.sound.midi.Soundbank;
import java.util.Objects;
import java.util.Optional;

public class BookUsecase implements IBookUsecase{

    @Override
    public boolean getValidatedEntity(BooKDTO bookDTO) {
        if(Objects.isNull(bookDTO.getIsbn())){
            return false;
        }
        if(Objects.isNull(bookDTO.getTitle())){
            return false;
        }
        if(Objects.isNull(bookDTO.getAuthorId())){
            return false;
        }
        if(Objects.isNull(bookDTO.getPublisherId())){
            return false;
        }

        return true;
    }

    @Override
    public Book entityBuilder(BooKDTO dto) {
        Book book = new Book();
        book.setIsbn(dto.getIsbn());
        book.setTitle(dto.getTitle());
        book.setAuthorId(dto.getAuthorId());
        book.setPublisherId(dto.getPublisherId());
        book.setEdition(dto.getEdition());
        book.setPublicationDate(dto.getPublicationDate());
        book.setCategoryId(dto.getCategoryId());
        book.setBestSeller(dto.getBestSeller());

        return book;
    }

    @Override
    public boolean allowUpdate(long id, BooKDTO dto) {
        BookDAO repo = new BookDAO();
        Book book = repo.findById(id);
        if(Objects.isNull(book)){
            return false;
        }
        System.out.println("db: "+book.getIsbn() + " - dto: "+dto.getIsbn());
        if(!book.getIsbn().equals(dto.getIsbn())){
            return false;
        }
        return true;
    }
}
