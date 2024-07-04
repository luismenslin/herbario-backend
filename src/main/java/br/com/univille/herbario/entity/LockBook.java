package br.com.univille.herbario.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lock_book")
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LockBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "data_locked", nullable = false)
    private LocalDate dataLocked;

    @Column(name = "data_unlocked")
    private LocalDate dataUnlocked;

    public LockBook (Book book, Person person) {
        this.book = book;
        this.person = person;
        dataLocked = LocalDate.now();
        dataUnlocked = null;
    }
}