package br.com.univille.herbario.service.impl;

import br.com.univille.herbario.entity.Person;
import br.com.univille.herbario.repository.PersonRepository;
import br.com.univille.herbario.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public void save(Person person) {
        repository.save(person);
    }

    @Override
    public Person getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }

    @Override
    public Person delete(long id) {
        var person = repository.getById(id);
        repository.delete(person);
        return person;
    }
}
