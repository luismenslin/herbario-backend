package br.com.univille.herbario.controller;

import br.com.univille.herbario.entity.Book;
import br.com.univille.herbario.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpLogging;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        var bookList  = service.getAll();
        return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id){
        return new ResponseEntity<Book>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> post(@RequestBody Book book){
        if(book.getId() == 0){
            service.save(book);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> put(@PathVariable long id,
                                       @RequestBody Book book){
        var oldBook = service.getById(id);
        if(oldBook == null){
            return ResponseEntity.notFound().build();
        }

        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setEdition(book.getEdition());
        oldBook.setPublication(book.getPublication());

        service.save(oldBook);
        return new ResponseEntity<Book>(oldBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable long id){
        var book = service.getById(id);
        if(book == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Book>(book,HttpStatus.OK);
    }
}
