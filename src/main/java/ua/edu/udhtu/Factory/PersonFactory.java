package ua.edu.udhtu.Factory;

import org.springframework.stereotype.Component;
import ua.edu.udhtu.Factory.impl.AbstractTableFactory;
import ua.edu.udhtu.model.dto.PersonDto;
import ua.edu.udhtu.model.entity.PersonEntity;
@Component
public class PersonFactory extends AbstractTableFactory<PersonEntity, PersonDto, Long> {
    @Override
    protected PersonDto buildDto(PersonEntity entity, boolean all) {
        PersonDto dto = new PersonDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setLastName(entity.getLastName());
        dto.setBirthDay(entity.getBirthDay());
        dto.setNumberPhone(entity.getNumberPhone());
        return dto;
    }

    @Override
    protected PersonEntity createEmptyEntity() {
        return new PersonEntity();
    }

    @Override
    protected PersonDto createEmptyDto() {
        return new PersonDto();
    }

    @Override
    protected void fillEntity(PersonDto dto, PersonEntity entity) {
        fillEntityWithOnlyId(dto, entity);
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setMiddleName(dto.getMiddleName());
        entity.setLastName(dto.getLastName());
        entity.setBirthDay(dto.getBirthDay());
        entity.setNumberPhone(dto.getNumberPhone());
    }

    @Override
    protected void fillEntityWithOnlyId(PersonDto dto, PersonEntity entity) {
        entity.setId(dto.getId());
    }
}
