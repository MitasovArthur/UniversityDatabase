package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.PersonDto;
import ua.edu.udhtu.model.dto.StudyGroupDto;
import ua.edu.udhtu.model.dto.SubjectDto;
import ua.edu.udhtu.model.dto.TeacherDto;
import ua.edu.udhtu.model.entity.PersonEntity;
import ua.edu.udhtu.model.entity.StudyGroupEntity;
import ua.edu.udhtu.model.entity.SubjectEntity;
import ua.edu.udhtu.model.entity.TeacherEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class TeacherFactory extends AbstractTableFactory<TeacherEntity, TeacherDto, Long> {
    private AbstractTableFactory<PersonEntity, PersonDto, Long> personFactory;
    private AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory;
    /**
     * Это нужно
     */
    private AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> studyGroupFactory;

    public void setPersonFactory(AbstractTableFactory<PersonEntity, PersonDto, Long> personFactory) {
        this.personFactory = personFactory;
    }

    public void setStudyGroupFactory(AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> studyGroupFactory) {
        this.studyGroupFactory = studyGroupFactory;
    }

    public void setSubjectFactory(AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory) {
        this.subjectFactory = subjectFactory;
    }


    @Override
    protected TeacherDto buildDto(TeacherEntity entity, boolean all) {
        TeacherDto dto = new TeacherDto();
        dto.setId(entity.getId());
        dto.setPerson(personFactory.createDto(entity.getPerson()));
        dto.setAcademicDegree(entity.getAcademicDegree());
//        dto.setStudyGroup(studyGroupFactory.createDto(entity.getStudyGroup()));
        return dto;
    }

    @Override
    protected TeacherEntity createEmptyEntity() {
        return new TeacherEntity();
    }

    @Override
    protected TeacherDto createEmptyDto() {
        return new TeacherDto();
    }

    @Override
    protected void fillEntity(TeacherDto dto, TeacherEntity entity) {
        fillEntityWithOnlyId(dto, entity);
        entity.setPerson(personFactory.createEntity(dto.getPerson()));
        entity.setAcademicDegree(dto.getAcademicDegree());
//        entity.setStudyGroup(studyGroupFactory.createEntity(dto.getStudyGroup()));
    }

    @Override
    protected void fillEntityWithOnlyId(TeacherDto dto, TeacherEntity entity) {
        entity.setId(dto.getId());
    }
}
