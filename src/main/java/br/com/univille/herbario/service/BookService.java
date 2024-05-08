package br.com.univille.herbario.service;

import br.com.univille.herbario.entity.Book;
import java.util.List;

public interface BookService {
    void save(Book book);
    Book getById(long id);
    List<Book> getAll();
    Book delete(long id);
}
