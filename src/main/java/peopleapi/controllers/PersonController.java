package peopleapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peopleapi.dtos.RequestPerson;
import peopleapi.mapper.PersonMapper;
import peopleapi.model.Person;
import peopleapi.repositoy.PersonRepository;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonMapper personMapper;


    @Autowired
    private PersonRepository personRepository;

    public PersonController(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @GetMapping
    public ResponseEntity getAllPerson() {
        var allPerson = personRepository.findAll();
        return ResponseEntity.ok(allPerson);
    }

    @PostMapping()
    public ResponseEntity savePerson(@RequestBody RequestPerson requestPerson){
        Person person = personMapper.convertToEntity(requestPerson);
        personRepository.save(person);
        return ResponseEntity.ok().build();
    }
}
