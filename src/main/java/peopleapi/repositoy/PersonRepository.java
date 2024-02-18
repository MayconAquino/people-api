package peopleapi.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import peopleapi.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsByCpf(String cpf);

}
