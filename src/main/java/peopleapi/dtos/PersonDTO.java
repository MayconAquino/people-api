package peopleapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
    private String name;
    private String cpf;
    private String address;
    private String office;
}
