package peopleapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record RequestPerson(
         String name,
         String cpf,
         String address,
         String office
) {
    
}
