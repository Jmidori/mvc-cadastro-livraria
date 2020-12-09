package com.livraria.cadastrolivro.controller;

import com.livraria.cadastrolivro.controller.request.BookDTO;
import com.livraria.cadastrolivro.model.dao.entity.Book;
import com.livraria.cadastrolivro.model.dao.impl.BookDAO;
import com.livraria.cadastrolivro.model.usecase.IRegisterStrategy;
import com.livraria.cadastrolivro.model.usecase.impl.BookUsecase;
import com.livraria.cadastrolivro.util.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/livros")
public class BookController {
    private BookDAO repository;
    private Log log;
    private IRegisterStrategy strategy;


    public BookController() {
        this.repository = new BookDAO();
        this.log = new Log();
        this.strategy = new BookUsecase();
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
    public ResponseEntity<String> createBook(@RequestBody BookDTO book){
        try{
            if(!strategy.getValidatedEntity(book)){
                return new ResponseEntity("Livro nao cadastrado! Verifique os campos obrigatorios" ,HttpStatus.BAD_REQUEST);
            }
            repository.save(strategy.entityBuilder(book));

        }catch (RuntimeException e){
            new Log().generateErrorLog(LocalDateTime.now(), "registrar o livro: " + book.toString() +" no BD", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateBook(@RequestBody BookDTO book, @PathVariable(value = "id") long id){
        try{
            if(!strategy.validConditionForUpdate(id, book)){
                return new ResponseEntity("Livro nao alterado! - O ISBN nao pode ser alterado e/ou campos obrigatorios devem estar preenchidos." ,HttpStatus.BAD_REQUEST);
            }

            repository.update(strategy.entityBuilder(book),id);
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
