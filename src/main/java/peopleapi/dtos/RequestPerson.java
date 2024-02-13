package peopleapi.dtos;

public record RequestPerson(
         String name,
         String cpf,
         String address,
         String office
) {}
