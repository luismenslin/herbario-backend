package br.com.univille.herbario.service;

import br.com.univille.herbario.entity.Person;

import java.util.List;

public interface PersonService {
    void save(Person person);
    Person getById(long id);
    List<Person> getAll();
    Person delete(long id);
}
