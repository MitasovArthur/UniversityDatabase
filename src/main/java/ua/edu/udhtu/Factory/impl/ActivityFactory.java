package ua.edu.udhtu.Factory.impl;

import org.springframework.stereotype.Component;
import ua.edu.udhtu.model.dto.ActivityDto;
import ua.edu.udhtu.model.dto.GradeBookDto;
import ua.edu.udhtu.model.dto.StudentDto;
import ua.edu.udhtu.model.dto.SubjectDto;
import ua.edu.udhtu.model.entity.ActivityEntity;
import ua.edu.udhtu.model.entity.GradeBookEntity;
import ua.edu.udhtu.model.entity.StudentEntity;
import ua.edu.udhtu.model.entity.SubjectEntity;

@Component
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
//        dto.setSubjectDto(subjectFactory.createDto(entity.getSubject()));/***/
        dto.setNameActivity(entity.getNameActivity());
        dto.setDescription(entity.getDescription());
        dto.setDeadLine(entity.getDeadLine());
//        dto.setStudentDto(studentFactory.createDto(entity.getStudent()));/***/
        dto.setGrade(entity.getGrade());
//        dto.setGradeBookDto(gradeBookFactory.createDto(entity.getGradeBook()));/***/
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
//        entity.setSubject(subjectFactory.createEntity(dto.getSubjectDto()));/***/
        entity.setNameActivity(dto.getNameActivity());
        entity.setDescription(dto.getDescription());
        entity.setDeadLine(dto.getDeadLine());
//        entity.setStudent(studentFactory.createEntity(dto.getStudentDto()));/***/
        entity.setGrade(dto.getGrade());
//        entity.setGradeBook(gradeBookFactory.createEntity(dto.getGradeBookDto()));/***/
    }

    @Override
    protected void fillEntityWithOnlyId(ActivityDto dto, ActivityEntity entity) {
        entity.setId(dto.getId());
    }
}
