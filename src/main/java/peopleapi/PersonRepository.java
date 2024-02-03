package peopleapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peopleapi.model.Person;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long> {
}
