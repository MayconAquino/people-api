package peopleapi.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import peopleapi.dtos.RequestPerson;

@Service
public class PersonMapper {

    private final ModelMapper modelMapper;

    public PersonMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public peopleapi.model.Person convertToEntity(RequestPerson requestPerson) {
        return modelMapper.map(requestPerson, peopleapi.model.Person.class);
    }
}
