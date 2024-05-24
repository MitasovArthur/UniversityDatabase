package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.*;
import ua.edu.udhtu.model.entity.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class TeacherFactory extends AbstractTableFactory<TeacherEntity, TeacherDto, Long> {
    private AbstractTableFactory<PersonEntity, PersonDto, Long> personFactory;
    private AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> studyGroupFactory;
    private AbstractTableFactory<GradeBookEntity, GradeBookDto, Long> gradeBookFactory;
    private AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory;
    private AbstractTableFactory<TimetableOfClassesEntity, TimetableOfClassesDto, Long> timeTableOfClassFactory;

    public void setPersonFactory(AbstractTableFactory<PersonEntity, PersonDto, Long> personFactory) {
        this.personFactory = personFactory;
    }

    public void setStudyGroupFactory(AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> studyGroupFactory) {
        this.studyGroupFactory = studyGroupFactory;
    }

    public void setGradeBookFactory(AbstractTableFactory<GradeBookEntity, GradeBookDto, Long> gradeBookFactory) {
        this.gradeBookFactory = gradeBookFactory;
    }

    public void setSubjectFactory(AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory) {
        this.subjectFactory = subjectFactory;
    }

    public void setTimeTableOfClassFactory(AbstractTableFactory<TimetableOfClassesEntity, TimetableOfClassesDto, Long> timeTableOfClassFactory) {
        this.timeTableOfClassFactory = timeTableOfClassFactory;
    }

    @Override
    protected TeacherDto buildDto(TeacherEntity entity, boolean all) {
        TeacherDto dto = new TeacherDto();
        dto.setId(entity.getId());
        dto.setPerson(personFactory.createDto(entity.getPerson()));
        dto.setAcademicDegree(entity.getAcademicDegree());
        if (entity.getStudyGroup() != null) {
            dto.setStudyGroup(studyGroupFactory.createMinimalDto(entity.getStudyGroup()));
        }

        if (entity.getGradeBooks() != null && !entity.getGradeBooks().isEmpty()) {
            dto.setGradeBook(new ArrayList<>());
            for (GradeBookEntity gradeBook : entity.getGradeBooks()) {
                dto.getGradeBook().add(gradeBookFactory.createMinimalDto(gradeBook));
            }
        }
        if (entity.getSubjects() != null && !entity.getSubjects().isEmpty()) {
            dto.setSubjects(new LinkedHashSet<>());
            for (SubjectEntity subject : entity.getSubjects()) {
                dto.getSubjects().add(subjectFactory.createMinimalDto(subject));
            }
        }
        if (entity.getTimetableOfClasses() != null && !entity.getTimetableOfClasses().isEmpty()) {
            dto.setTimetableOfClasses(new ArrayList<>());
            for (TimetableOfClassesEntity timetableOfClasses : entity.getTimetableOfClasses()) {
                dto.getTimetableOfClasses().add(timeTableOfClassFactory.createMinimalDto(timetableOfClasses));
            }
        }
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
    }

    @Override
    protected void fillEntityWithOnlyId(TeacherDto dto, TeacherEntity entity) {
        entity.setId(dto.getId());
    }

    @Override
    protected TeacherDto createMinimalDto(TeacherEntity entity) {
        if (entity == null) return null;
        TeacherDto dto = new TeacherDto();
        dto.setId(entity.getId());
        dto.setPerson(personFactory.createDto(entity.getPerson()));
        dto.setAcademicDegree(entity.getAcademicDegree());
        return dto;
    }

    @Override
    protected TeacherEntity createMinimalEntity(TeacherDto dto) {
        if (dto == null) return null;
        TeacherEntity entity = new TeacherEntity();
        entity.setId(dto.getId());
        entity.setPerson(personFactory.createEntity(dto.getPerson()));
        entity.setAcademicDegree(dto.getAcademicDegree());
        if (dto.getStudyGroup() != null) {
            entity.setStudyGroup(studyGroupFactory.createEntityWithOnlyId(dto.getStudyGroup()));
        }
        return entity;
    }

}
