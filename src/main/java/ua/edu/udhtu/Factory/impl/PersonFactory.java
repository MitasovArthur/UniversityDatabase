package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.PersonDto;
import ua.edu.udhtu.model.entity.PersonEntity;

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

    @Override
    protected PersonDto createMinimalDto(PersonEntity studyGroup) {
        return null;
    }

    @Override
    protected PersonEntity createMinimalEntity(PersonDto studyGroupDto) {
        return null;
    }
}
