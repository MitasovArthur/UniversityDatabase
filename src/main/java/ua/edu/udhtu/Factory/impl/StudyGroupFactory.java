package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.*;
import ua.edu.udhtu.model.entity.*;

import java.util.ArrayList;

public class StudyGroupFactory extends AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> {
    private AbstractTableFactory<StudentEntity, StudentDto, Long> studentFactory;
    private AbstractTableFactory<TeacherEntity, TeacherDto, Long> teacherFactory;
    private AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory;
    private AbstractTableFactory<GradeBookEntity, GradeBookDto, Long> gradeBookFactory;
    private AbstractTableFactory<TimetableOfClassesEntity, TimetableOfClassesDto, Long> timeTableOfClassFactory;

    public void setStudentFactory(AbstractTableFactory<StudentEntity, StudentDto, Long> studentFactory) {
        this.studentFactory = studentFactory;
    }

    public void setTeacherFactory(AbstractTableFactory<TeacherEntity, TeacherDto, Long> teacherFactory) {
        this.teacherFactory = teacherFactory;
    }

    public void setSubjectFactory(AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory) {
        this.subjectFactory = subjectFactory;
    }

    public void setGradeBookFactory(AbstractTableFactory<GradeBookEntity, GradeBookDto, Long> gradeBookFactory) {
        this.gradeBookFactory = gradeBookFactory;
    }

    public void setTimeTableOfClassFactory(AbstractTableFactory<TimetableOfClassesEntity, TimetableOfClassesDto, Long> timeTableOfClassFactory) {
        this.timeTableOfClassFactory = timeTableOfClassFactory;
    }

    @Override
    protected StudyGroupDto buildDto(StudyGroupEntity entity, boolean all) {
        StudyGroupDto dto = new StudyGroupDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        if (entity.getCurator() != null) {
            dto.setCurator(teacherFactory.createMinimalDto(entity.getCurator()));
        }
        if (entity.getGradeBook() != null) {
            dto.setGradeBook(gradeBookFactory.createMinimalDto(entity.getGradeBook()));
        }
        if (entity.getStudents() != null && !entity.getStudents().isEmpty()) {
            dto.setStudents(new ArrayList<>());
            for (StudentEntity student : entity.getStudents())
                dto.getStudents().add(studentFactory.createMinimalDto(student));
        }
        if (entity.getTimetableOfClasses() != null && !entity.getTimetableOfClasses().isEmpty()) {
            dto.setTimetableOfClasses(new ArrayList<>());
            for (TimetableOfClassesEntity timetableOfClasses : entity.getTimetableOfClasses()) {
                dto.getTimetableOfClasses().add(timeTableOfClassFactory.createMinimalDto(timetableOfClasses));
            }
        }
        if (entity.getSubjects() != null && !entity.getSubjects().isEmpty()) {
            dto.setSubjects(new ArrayList<>());
            for (SubjectEntity subject : entity.getSubjects())
                dto.getSubjects().add(subjectFactory.createMinimalDto(subject));
        }
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
        fillEntityWithOnlyId(dto, entity);
        entity.setCode(dto.getCode());
        if (dto.getCurator() != null) {
            entity.setCurator(teacherFactory.createEntityWithOnlyId(dto.getCurator()));
        }
        if (dto.getGradeBook() != null) {
            entity.setGradeBook(gradeBookFactory.createEntityWithOnlyId(dto.getGradeBook()));
        }
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

    public StudyGroupEntity createMinimalEntity(StudyGroupDto dto) {
        if (dto == null) return null;
        StudyGroupEntity entity = new StudyGroupEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        return entity;
    }
}
