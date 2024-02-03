package peopleapi.services;

import org.springframework.stereotype.Service;
import peopleapi.model.Person;

import java.util.List;

@Service
public interface PersonService {

     List<Person> getAllPersons();
     Person getPersonById(Long id);
     Person createPerson(Person person);
     Person updatePerson(Long id, Person person);
     void deletePerson(Person person);
}
