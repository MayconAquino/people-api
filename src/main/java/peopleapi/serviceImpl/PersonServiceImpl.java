package peopleapi.serviceImpl;

import peopleapi.PersonRepository;
import peopleapi.dtos.PersonDTO;
import peopleapi.model.Person;
import peopleapi.services.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.getReferenceById(id);
    }

    @Override
    public Person createPerson(Person person) {
        return null;
    }
    @Override
    public Person updatePerson(Long id, Person person) {
        return null;
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }
}
