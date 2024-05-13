package br.com.univille.herbario.controller;

import br.com.univille.herbario.entity.Person;
import br.com.univille.herbario.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<List<Person>> getPerson() {
        var personList = service.getAll();
        return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getBookById(@PathVariable long id){
        return new ResponseEntity<Person>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> post(@RequestBody Person person){
        if(person.getId() == 0){
            service.save(person);
            return new ResponseEntity<Person>(person, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> put(@PathVariable long id,
                                    @RequestBody Person person){
        var oldPerson = service.getById(id);
        if(oldPerson == null){
            return ResponseEntity.notFound().build();
        }

        oldPerson.setName(person.getName());
        oldPerson.setGraduation(person.getGraduation());
        oldPerson.setPhone(person.getPhone());

        service.save(oldPerson);
        return new ResponseEntity<Person>(oldPerson, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable long id){
        var person = service.getById(id);
        if(person == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Person>(person,HttpStatus.OK);
    }
}
