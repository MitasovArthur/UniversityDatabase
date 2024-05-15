package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.*;
import ua.edu.udhtu.model.entity.PersonEntity;
import ua.edu.udhtu.model.entity.StudentEntity;
import ua.edu.udhtu.model.entity.StudyGroupEntity;
import ua.edu.udhtu.model.entity.TeacherEntity;

import java.util.ArrayList;

public class StudyGroupFactory extends AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> {
    private AbstractTableFactory<StudentEntity, StudentDto, Long> studentFactory;
    private AbstractTableFactory<TeacherEntity, TeacherDto, Long> teacherFactory;

    public void setStudentFactory(AbstractTableFactory<StudentEntity, StudentDto, Long> studentFactory) {
        this.studentFactory = studentFactory;
    }

    public void setTeacherFactory(AbstractTableFactory<TeacherEntity, TeacherDto, Long> teacherFactory) {
        this.teacherFactory = teacherFactory;
    }

    @Override
    protected StudyGroupDto buildDto(StudyGroupEntity entity, boolean all) {
        StudyGroupDto dto = new StudyGroupDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setCurator(teacherFactory.createDto(entity.getCurator()));
        return dto;
    }

    @Override
    protected StudyGroupEntity createEmptyEntity() {
       return new StudyGroupEntity();
    }

    @Override
    protected StudyGroupDto createEmptyDto() {
        return new StudyGroupDto();
    }

    @Override
    protected void fillEntity(StudyGroupDto dto, StudyGroupEntity entity) {
    fillEntityWithOnlyId(dto,entity);
    entity.setCode(dto.getCode());
    entity.setCurator(teacherFactory.createEntity(dto.getCurator()));
    }

    @Override
    protected void fillEntityWithOnlyId(StudyGroupDto dto, StudyGroupEntity entity) {
    entity.setId(dto.getId());
    }

    public StudyGroupDto createMinimalDto(StudyGroupEntity entity) {
        if (entity == null) return null;
        StudyGroupDto dto = new StudyGroupDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        return dto;
    }
}
