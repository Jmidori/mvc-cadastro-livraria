package com.livraria.cadastrolivro.controller;

import com.livraria.cadastrolivro.model.entity.Book;
import com.livraria.cadastrolivro.model.repository.impl.BookDAO;
import com.livraria.cadastrolivro.model.usecase.IBookUsecase;
import com.livraria.cadastrolivro.model.usecase.impl.BookUsecase;
import com.livraria.cadastrolivro.util.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/livros")
public class BookController {
    private BookDAO repository;
    private Log log;
    private IBookUsecase useCase;


    public BookController() {
        this.repository = new BookDAO();
        this.useCase = new BookUsecase();
        this.log = new Log();
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getBooks(){
        try{
            return new ResponseEntity<>(repository.getAll(), HttpStatus.OK);

        }catch (RuntimeException e){
            log.generateErrorLog(LocalDateTime.now(), "buscar os livros no BD", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getCarById(@PathVariable(value = "id") long id){
        try{
            Book book = repository.findById(id);
            if(Objects.isNull(book)) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(book);

        } catch (RuntimeException e){
            new Log().generateErrorLog(LocalDateTime.now(), "buscar o livro de id: " + id +" no BD", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody BooKDTO book){
        try{
            if(!useCase.getValidatedEntity(book)){
                return new ResponseEntity("Livro nao cadastrado! Verifique os campos obrigatorios" ,HttpStatus.BAD_REQUEST);
            }
            repository.save(useCase.entityBuilder(book));

        }catch (RuntimeException e){
            new Log().generateErrorLog(LocalDateTime.now(), "registrar o livro: " + book.toString() +" no BD", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateBook(@RequestBody BooKDTO book, @PathVariable(value = "id") long id){
        try{
            if(!useCase.getValidatedEntity(book)){
                return new ResponseEntity("Livro nao alterado! Verifique os campos obrigatorios" ,HttpStatus.BAD_REQUEST);
            }
            if(!useCase.allowUpdate(id, book)){
                return new ResponseEntity("O ISBN do livro nao pode ser alterado" ,HttpStatus.BAD_REQUEST);
            }
            repository.update(useCase.entityBuilder(book),id);
            log.generateRegisterLog(LocalDateTime.now(), " - ATUALIZADO livro de id: "+ id);

        }catch (RuntimeException e){
            new Log().generateErrorLog(LocalDateTime.now(), "registrar o livro: " + book.toString() +" no BD", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "id") long id){
        try{
            repository.delete(id);

        }catch (RuntimeException e){
            new Log().generateErrorLog(LocalDateTime.now(), "excluir o livro de id: " + id +" no BD", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
