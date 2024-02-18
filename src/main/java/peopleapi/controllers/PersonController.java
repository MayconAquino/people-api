package peopleapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peopleapi.dtos.RequestPerson;
import peopleapi.exception.ExceptionPersonExists;
import peopleapi.exception.ExceptionPersonNotExists;
import peopleapi.mapper.PersonMapper;
import peopleapi.model.Person;
import peopleapi.repositoy.PersonRepository;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private final PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    public PersonController(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @GetMapping
    public ResponseEntity getAllPerson() {
        var allPerson = personRepository.findAll();

        try {
            if (allPerson.isEmpty()) {
                throw new ExceptionPersonNotExists();
            }
            return ResponseEntity.ok(allPerson);
        }catch (ExceptionPersonNotExists ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No person was found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getPersonById(@PathVariable Long id) {
        try {
            Person person = personRepository.findById(id)
                    .orElseThrow(ExceptionPersonNotExists::new);
            return ResponseEntity.ok(person);
        } catch (ExceptionPersonNotExists ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
        }
    }

    @PostMapping()
    public ResponseEntity savePerson(@RequestBody RequestPerson requestPerson){

        try {
            if (personRepository.existsByCpf(requestPerson.cpf())) {
                throw new ExceptionPersonExists();
            }
            Person person = personMapper.toPerson(requestPerson);
            personRepository.save(person);
            return ResponseEntity.ok().build();
        } catch (ExceptionPersonExists ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Person with the same CPF already exists");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(Person id) {
        personRepository.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePerson(@PathVariable Long id, @RequestBody RequestPerson requestPerson){

        try {
            Person existingPerson = personRepository.findById(id)
                    .orElseThrow(ExceptionPersonNotExists::new);
            personMapper.updatePersonFromRequest(existingPerson, requestPerson);
            personRepository.save(existingPerson);
            return ResponseEntity.ok().build();

        }catch (ExceptionPersonNotExists ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No person was found");

        }
    }
}
