package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.PersonDto;
import ua.edu.udhtu.model.dto.StudentDto;
import ua.edu.udhtu.model.entity.PersonEntity;
import ua.edu.udhtu.model.entity.StudentEntity;


public class StudentFactory extends AbstractTableFactory<StudentEntity, StudentDto, Long> {
    private AbstractTableFactory<PersonEntity, PersonDto, Long> personFactory;

    public void setPersonFactory(AbstractTableFactory<PersonEntity, PersonDto, Long> personFactory) {
        this.personFactory = personFactory;
    }

    @Override
    protected StudentDto buildDto(StudentEntity entity, boolean all) {
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setPerson(personFactory.createDto(entity.getPerson()));
        dto.setEducationType(entity.getEducationType());
        dto.setAddress(entity.getAddress());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    @Override
    protected StudentEntity createEmptyEntity() {
        return new StudentEntity();
    }

    @Override
    protected StudentDto createEmptyDto() {
        return new StudentDto();
    }

    @Override
    protected void fillEntity(StudentDto dto, StudentEntity entity) {
        fillEntityWithOnlyId(dto, entity);
        entity.setId(dto.getId());
        entity.setPerson(personFactory.createEntityWithOnlyId(dto.getPerson()));
        entity.setEducationType(dto.getEducationType());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
    }

    @Override
    protected void fillEntityWithOnlyId(StudentDto dto, StudentEntity entity) {
        entity.setId(dto.getId());
    }
}
