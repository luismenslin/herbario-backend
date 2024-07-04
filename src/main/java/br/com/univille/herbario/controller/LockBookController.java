package br.com.univille.herbario.controller;

import br.com.univille.herbario.entity.Book;
import br.com.univille.herbario.entity.LockBook;
import br.com.univille.herbario.service.LockBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/lockbooks")
public class LockBookController {

    @Autowired
    private LockBookService lockBookService;

    @GetMapping
    public ResponseEntity<List<LockBook>> getLockBooks(){
        var lockBookList  = lockBookService.getAll();
        return new ResponseEntity<List<LockBook>>(lockBookList, HttpStatus.OK);
    }

    @PostMapping("/lock")
    public ResponseEntity<Void> lockBook(@RequestParam long bookId, @RequestParam long personId) {
        lockBookService.lockBook(bookId, personId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/unlock/{bookId}")
    public ResponseEntity<Void> unlockBook(@PathVariable long bookId) {
        try {
            lockBookService.unlockBook(bookId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}