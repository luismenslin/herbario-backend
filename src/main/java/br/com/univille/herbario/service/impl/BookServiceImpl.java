package br.com.univille.herbario.service.impl;

import br.com.univille.herbario.entity.Book;
import br.com.univille.herbario.repository.BookRepository;
import br.com.univille.herbario.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public Book getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Book delete(long id) {
        var book = repository.getById(id);
        repository.delete(book);
        return book;
    }
}
