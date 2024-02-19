package peopleapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import peopleapi.dtos.RequestPerson;
import peopleapi.model.Person;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

     Person toPerson(RequestPerson requestPerson);


    void updatePersonFromRequest(@MappingTarget Person existingPerson, RequestPerson requestPerson);
}