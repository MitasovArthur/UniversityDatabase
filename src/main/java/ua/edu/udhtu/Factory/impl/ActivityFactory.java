package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.ActivityDto;
import ua.edu.udhtu.model.dto.GradeBookDto;
import ua.edu.udhtu.model.dto.StudentDto;
import ua.edu.udhtu.model.dto.SubjectDto;
import ua.edu.udhtu.model.entity.ActivityEntity;
import ua.edu.udhtu.model.entity.GradeBookEntity;
import ua.edu.udhtu.model.entity.StudentEntity;
import ua.edu.udhtu.model.entity.SubjectEntity;

public class ActivityFactory extends AbstractTableFactory<ActivityEntity, ActivityDto, Long> {
    private AbstractTableFactory<StudentEntity, StudentDto, Long> studentFactory;
    private AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory;
    private AbstractTableFactory<GradeBookEntity, GradeBookDto, Long> gradeBookFactory;

    public void setStudentFactory(AbstractTableFactory<StudentEntity, StudentDto, Long> studentFactory) {
        this.studentFactory = studentFactory;
    }

    public void setSubjectFactory(AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory) {
        this.subjectFactory = subjectFactory;
    }

    public void setGradeBookFactory(AbstractTableFactory<GradeBookEntity, GradeBookDto, Long> gradeBookFactory) {
        this.gradeBookFactory = gradeBookFactory;
    }

    @Override
    protected ActivityDto buildDto(ActivityEntity entity, boolean all) {
        ActivityDto dto = new ActivityDto();
        dto.setId(entity.getId());
        if (entity.getStudent() != null) {
            dto.setSubject(subjectFactory.createMinimalDto(entity.getSubject()));
        }
        dto.setNameActivity(entity.getNameActivity());
        dto.setDescription(entity.getDescription());
        dto.setDeadLine(entity.getDeadLine());
        if (entity.getStudent() != null) {
            dto.setStudent(studentFactory.createMinimalDto(entity.getStudent()));
        }
        dto.setGrade(entity.getGrade());
        if (entity.getGradeBook() != null) {
            dto.setGradeBook(gradeBookFactory.createMinimalDto(entity.getGradeBook()));
        }
        return dto;
    }

    @Override
    protected ActivityEntity createEmptyEntity() {
        return new ActivityEntity();
    }

    @Override
    protected ActivityDto createEmptyDto() {
        return new ActivityDto();
    }

    @Override
    protected void fillEntity(ActivityDto dto, ActivityEntity entity) {
        fillEntityWithOnlyId(dto, entity);
        entity.setId(dto.getId());
        if (dto.getSubject() != null) {
            entity.setSubject(subjectFactory.createEntityWithOnlyId(dto.getSubject()));
        }
        entity.setNameActivity(dto.getNameActivity());
        entity.setDescription(dto.getDescription());
        entity.setDeadLine(dto.getDeadLine());
        if (dto.getStudent() != null) {
            entity.setStudent(studentFactory.createEntityWithOnlyId(dto.getStudent()));
        }
        entity.setGrade(dto.getGrade());
        if (dto.getGradeBook() != null) {
            entity.setGradeBook(gradeBookFactory.createEntityWithOnlyId(dto.getGradeBook()));
        }
    }

    @Override
    protected void fillEntityWithOnlyId(ActivityDto dto, ActivityEntity entity) {
        entity.setId(dto.getId());
    }

    @Override
    protected ActivityDto createMinimalDto(ActivityEntity entity) {
        if (entity == null) return null;
        ActivityDto dto = new ActivityDto();
        dto.setId(entity.getId());
        dto.setNameActivity(entity.getNameActivity());
        dto.setGrade(entity.getGrade());
        return dto;
    }

    @Override
    protected ActivityEntity createMinimalEntity(ActivityDto dto) {
        if (dto == null) return null;
        ActivityEntity entity = new ActivityEntity();
        entity.setId(dto.getId());
        entity.setNameActivity(dto.getNameActivity());
        entity.setGrade(dto.getGrade());
        return entity;
    }
}
