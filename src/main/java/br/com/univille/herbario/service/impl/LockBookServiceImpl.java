package br.com.univille.herbario.service;

import br.com.univille.herbario.entity.Book;
import br.com.univille.herbario.entity.LockBook;
import br.com.univille.herbario.entity.Person;
import br.com.univille.herbario.repository.BookRepository;
import br.com.univille.herbario.repository.LockBookRepository;
import br.com.univille.herbario.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class LockBookServiceImpl implements LockBookService {

    @Autowired
    private LockBookRepository lockBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void lockBook(long bookId, long personId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + bookId));

        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException("Person not found with id: " + personId));

        LockBook lockBook = new LockBook(book,person);
        lockBook.setDataLocked(LocalDate.now());
        lockBookRepository.save(lockBook);
    }

    @Override
    @Transactional
    public void unlockBook(Long bookId) {
        LockBook lockBook = lockBookRepository.findByBookIdAndDataUnlockedIsNull(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book is not currently locked or does not exist with id: " + bookId));

        lockBook.setDataUnlocked(LocalDate.now());
        lockBookRepository.save(lockBook);
    }

    @Override
    public List<LockBook> getAll() {
        return lockBookRepository.findAll();
    }
}