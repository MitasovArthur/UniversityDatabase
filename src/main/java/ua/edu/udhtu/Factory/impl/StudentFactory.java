package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.ActivityDto;
import ua.edu.udhtu.model.dto.PersonDto;
import ua.edu.udhtu.model.dto.StudentDto;
import ua.edu.udhtu.model.dto.StudyGroupDto;
import ua.edu.udhtu.model.entity.ActivityEntity;
import ua.edu.udhtu.model.entity.PersonEntity;
import ua.edu.udhtu.model.entity.StudentEntity;
import ua.edu.udhtu.model.entity.StudyGroupEntity;

import java.util.ArrayList;


public class StudentFactory extends AbstractTableFactory<StudentEntity, StudentDto, Long> {
    private AbstractTableFactory<PersonEntity, PersonDto, Long> personFactory;
    private AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> studyGroupFactory;
    public AbstractTableFactory<ActivityEntity, ActivityDto, Long> activityFactory;

    public void setPersonFactory(AbstractTableFactory<PersonEntity, PersonDto, Long> personFactory) {
        this.personFactory = personFactory;
    }

    public void setStudyGroupFactory(AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> studyGroupFactory) {
        this.studyGroupFactory = studyGroupFactory;
    }

    public void setActivityFactory(AbstractTableFactory<ActivityEntity, ActivityDto, Long> activityFactory) {
        this.activityFactory = activityFactory;
    }

    @Override
    protected StudentDto buildDto(StudentEntity entity, boolean all) {
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setPerson(personFactory.createDto(entity.getPerson()));
        dto.setEducationType(entity.getEducationType());
        dto.setAddress(entity.getAddress());
        dto.setEmail(entity.getEmail());
        if (entity.getStudyGroup() != null) {
            dto.setStudyGroup(studyGroupFactory.createMinimalDto(entity.getStudyGroup()));
        }
        if (entity.getActivity() != null && !entity.getActivity().isEmpty()) {
            dto.setActivity(new ArrayList<>());
            for (ActivityEntity activity : entity.getActivity()) {
                dto.getActivity().add(activityFactory.createMinimalDto(activity));
            }
        }

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
        entity.setPerson(personFactory.createEntity(dto.getPerson())); //
        entity.setEducationType(dto.getEducationType());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        if (dto.getStudyGroup() != null) {
            entity.setStudyGroup(studyGroupFactory.createEntityWithOnlyId(dto.getStudyGroup()));
        }
    }

    @Override
    protected void fillEntityWithOnlyId(StudentDto dto, StudentEntity entity) {
        entity.setId(dto.getId());
    }

    @Override
    public StudentDto createMinimalDto(StudentEntity entity) {
        if (entity == null) return null;
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setPerson(personFactory.createDto(entity.getPerson()));
        return dto;
    }

    @Override
    public StudentEntity createMinimalEntity(StudentDto dto) {
        if (dto == null) return null;
        StudentEntity entity = new StudentEntity();
        entity.setId(dto.getId());
        entity.setPerson(personFactory.createEntity(dto.getPerson()));
        return entity;
    }
}
