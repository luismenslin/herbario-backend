package br.com.univille.herbario.service;

import br.com.univille.herbario.entity.Book;
import br.com.univille.herbario.entity.LockBook;
import br.com.univille.herbario.entity.Person;

import java.util.List;
import java.util.concurrent.locks.Lock;

public interface LockBookService {
    void lockBook(long bookId, long personId);
    void unlockBook(Long bookId);

    List<LockBook> getAll();
}
