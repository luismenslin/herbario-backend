package br.com.univille.herbario.repository;

import br.com.univille.herbario.entity.LockBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LockBookRepository extends JpaRepository<LockBook, Long> {
    Optional<LockBook> findByBookIdAndDataUnlockedIsNull(Long bookId);

}
