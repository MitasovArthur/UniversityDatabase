package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.*;
import ua.edu.udhtu.model.entity.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class SubjectFactory extends AbstractTableFactory<SubjectEntity, SubjectDto, Long> {
    private AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> studyGroupFactory;
    public AbstractTableFactory<ActivityEntity, ActivityDto, Long> activityFactory;
    public AbstractTableFactory<GradeBookEntity, GradeBookDto, Long> gradeBookFactory;
    public AbstractTableFactory<TeacherEntity, TeacherDto, Long> teacherFactory;
    private AbstractTableFactory<TimetableOfClassesEntity, TimetableOfClassesDto, Long> timeTableOfClassFactory;

    public void setStudyGroupFactory(AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> studyGroupFactory) {
        this.studyGroupFactory = studyGroupFactory;
    }

    public void setActivityFactory(AbstractTableFactory<ActivityEntity, ActivityDto, Long> activityFactory) {
        this.activityFactory = activityFactory;
    }

    public void setGradeBookFactory(AbstractTableFactory<GradeBookEntity, GradeBookDto, Long> gradeBookFactory) {
        this.gradeBookFactory = gradeBookFactory;
    }

    public void setTeacherFactory(AbstractTableFactory<TeacherEntity, TeacherDto, Long> teacherFactory) {
        this.teacherFactory = teacherFactory;
    }

    public void setTimeTableOfClassFactory(AbstractTableFactory<TimetableOfClassesEntity, TimetableOfClassesDto, Long> timeTableOfClassFactory) {
        this.timeTableOfClassFactory = timeTableOfClassFactory;
    }

    @Override
    protected SubjectDto buildDto(SubjectEntity entity, boolean all) {
        SubjectDto dto = new SubjectDto();
        dto.setId(entity.getId());
        dto.setNameSubject(entity.getNameSubject());
        dto.setHourSubject(entity.getHourSubject());
        if (entity.getStudyGroup() != null) {
            dto.setStudyGroup(studyGroupFactory.createMinimalDto(entity.getStudyGroup()));
        }
        if (entity.getActivity() != null && !entity.getActivity().isEmpty()) {
            dto.setActivity(new ArrayList<>());
            for (ActivityEntity activity : entity.getActivity()) {
                dto.getActivity().add(activityFactory.createMinimalDto(activity));
            }
        }
        if (entity.getTimetableOfClasses() != null && !entity.getTimetableOfClasses().isEmpty()) {
            dto.setTimetableOfClasses(new ArrayList<>());
            for (TimetableOfClassesEntity timetableOfClasses : entity.getTimetableOfClasses()) {
                dto.getTimetableOfClasses().add(timeTableOfClassFactory.createMinimalDto(timetableOfClasses));
            }
        }
        if (entity.getGradeBooks() != null && !entity.getGradeBooks().isEmpty()) {
            dto.setGradeBook(new ArrayList<>());
            for (GradeBookEntity gradeBook : entity.getGradeBooks()) {
                dto.getGradeBook().add(gradeBookFactory.createMinimalDto(gradeBook));
            }
        }
        if (entity.getTeachers() != null && !entity.getTeachers().isEmpty()) {
            dto.setTeacher(new LinkedHashSet<>());
            for (TeacherEntity teacher : entity.getTeachers()) {
                dto.getTeacher().add(teacherFactory.createMinimalDto(teacher));
            }
        }

        dto.setHourSubject(entity.getHourSubject());
        return dto;
    }

    @Override
    protected SubjectEntity createEmptyEntity() {
        return new SubjectEntity();
    }

    @Override
    protected SubjectDto createEmptyDto() {
        return new SubjectDto();
    }

    @Override
    protected void fillEntity(SubjectDto dto, SubjectEntity entity) {
        fillEntityWithOnlyId(dto, entity);
        entity.setNameSubject(dto.getNameSubject());
        entity.setHourSubject(dto.getHourSubject());
        if (dto.getStudyGroup() != null) {
            entity.setStudyGroup(studyGroupFactory.createEntityWithOnlyId(dto.getStudyGroup()));
        }
    }

    @Override
    protected void fillEntityWithOnlyId(SubjectDto dto, SubjectEntity entity) {
        entity.setId(dto.getId());
    }

    @Override
    protected SubjectDto createMinimalDto(SubjectEntity entity) {
        if (entity == null) return null;
        SubjectDto dto = new SubjectDto();
        dto.setId(entity.getId());
        dto.setNameSubject(entity.getNameSubject());
        return dto;
    }

    @Override
    protected SubjectEntity createMinimalEntity(SubjectDto dto) {
        if (dto == null) return null;
        SubjectEntity entity = new SubjectEntity();
        entity.setId(dto.getId());
        entity.setNameSubject(dto.getNameSubject());
        return entity;
    }
}
