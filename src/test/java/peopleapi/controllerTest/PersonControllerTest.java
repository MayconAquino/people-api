package peopleapi.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import peopleapi.controllers.PersonController;
import peopleapi.dtos.RequestPerson;
import peopleapi.mapper.PersonMapper;
import peopleapi.model.Person;
import peopleapi.repositoy.PersonRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@MockitoSettings
class PersonControllerTest {

    @Mock
    private final PersonRepository personRepository = mock(PersonRepository.class);
    @Mock
    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    @InjectMocks
    private final PersonController personController = new PersonController(personMapper);


    @Test
    void getAllPerson_ReturnsOkResponse_WhenPersonsExist() {

        when(personRepository.findAll()).thenReturn(List.of(new Person()));

        ResponseEntity response = personController.getAllPerson();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getAllPerson_ReturnsConflictResponse_WhenNoPersonsExist() {
        when(personRepository.findAll()).thenReturn(Collections.emptyList());

        ResponseEntity response = personController.getAllPerson();

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("No person was found", response.getBody());
    }

    @Test
    void getPersonById_ReturnsOkResponse_WhenPersonExists() {
        when(personRepository.findById(anyLong())).thenReturn(Optional.of(new Person()));

        ResponseEntity response = personController.getPersonById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getPersonById_ReturnsNotFoundResponse_WhenPersonDoesNotExist() {
        when(personRepository.findById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity response = personController.getPersonById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Person not found", response.getBody());
    }

    @Test
    void savePerson_ReturnsOkResponse_WhenPersonIsSaved() {

        when(personRepository.existsByCpf(anyString())).thenReturn(false);

        ResponseEntity response = personController.savePerson(new RequestPerson(
                "Jose", "123.456.789-1", "Rua avenida", "ajudante"));

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void savePerson_ReturnsConflictResponse_WhenPersonWithSameCPFExists() {
        when(personRepository.existsByCpf(anyString())).thenReturn(true);

        ResponseEntity response = personController.savePerson(new RequestPerson(
                "Jose", "123.456.789-1", "Rua avenida", "ajudante"));

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("Person with the same CPF already exists", response.getBody());
    }
}
