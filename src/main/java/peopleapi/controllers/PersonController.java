package peopleapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import peopleapi.model.Person;
import peopleapi.serviceImpl.PersonServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonServiceImpl personServiceImpl;


    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.status(HttpStatus.OK).body(personServiceImpl.getAllPersons());
    }
}
