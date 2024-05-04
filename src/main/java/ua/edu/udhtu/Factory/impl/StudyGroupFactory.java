package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.ActivityDto;
import ua.edu.udhtu.model.dto.PersonDto;
import ua.edu.udhtu.model.dto.StudentDto;
import ua.edu.udhtu.model.dto.StudyGroupDto;
import ua.edu.udhtu.model.entity.PersonEntity;
import ua.edu.udhtu.model.entity.StudentEntity;
import ua.edu.udhtu.model.entity.StudyGroupEntity;

import java.util.ArrayList;

public class StudyGroupFactory extends AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> {
    private AbstractTableFactory<StudentEntity, StudentDto, Long> studentFactory;
    private AbstractTableFactory<PersonEntity, PersonDto, Long> personFactory;

    @Override
    protected StudyGroupDto buildDto(StudyGroupEntity entity, boolean all) {
        StudyGroupDto dto = new StudyGroupDto();
        dto.setId(entity.getId());
        dto.setCurator(entity.getCurator());
        if (entity.getStudents() != null) {
            dto.setStudents(new ArrayList<>(entity.getStudents().size()));
            entity.getStudents().forEach(studentEntity -> {
                StudentDto studentDto = new StudentDto();
                {
                    studentDto.setId(studentEntity.getId());
                    if (studentEntity.getPerson() != null) {
                        /** заполняем персону */
                        PersonDto personDto = new PersonDto();
                        personDto.setId(studentEntity.getPerson().getId());
                        personDto.setFirstName(studentEntity.getPerson().getFirstName());
                        personDto.setLastName(studentEntity.getPerson().getLastName());
                        personDto.setMiddleName(studentEntity.getPerson().getMiddleName());
                        personDto.setBirthDay(studentEntity.getPerson().getBirthDay());
                        personDto.setNumberPhone(studentEntity.getPerson().getNumberPhone());
                        /** сохраняем*/
                        studentDto.setPerson(personDto);
                    }
                    studentDto.setAddress(studentEntity.getAddress());
                    studentDto.setEmail(studentEntity.getEmail());
                    studentDto.setEducationType(studentEntity.getEducationType());
                }
            });

        }
        return dto;
    }

    @Override
    protected StudyGroupEntity createEmptyEntity() {
        return null;
    }

    @Override
    protected StudyGroupDto createEmptyDto() {
        return null;
    }

    @Override
    protected void fillEntity(StudyGroupDto dto, StudyGroupEntity entity) {

    }

    @Override
    protected void fillEntityWithOnlyId(StudyGroupDto dto, StudyGroupEntity entity) {

    }
}
