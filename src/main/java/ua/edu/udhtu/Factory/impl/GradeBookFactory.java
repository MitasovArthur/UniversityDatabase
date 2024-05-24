package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.*;
import ua.edu.udhtu.model.entity.*;

import java.util.ArrayList;

public class GradeBookFactory extends AbstractTableFactory<GradeBookEntity, GradeBookDto, Long> {
    private AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory;
    private AbstractTableFactory<TeacherEntity, TeacherDto, Long> teacherFactory;
    private AbstractTableFactory<ActivityEntity, ActivityDto, Long> activityFactory;
    private AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> studyGroupFactory;

    public void setSubjectFactory(AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory) {
        this.subjectFactory = subjectFactory;
    }

    public void setTeacherFactory(AbstractTableFactory<TeacherEntity, TeacherDto, Long> teacherFactory) {
        this.teacherFactory = teacherFactory;
    }

    public void setActivityFactory(AbstractTableFactory<ActivityEntity, ActivityDto, Long> activityFactory) {
        this.activityFactory = activityFactory;
    }

    public void setStudyGroupFactory(AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> studyGroupFactory) {
        this.studyGroupFactory = studyGroupFactory;
    }

    @Override
    protected GradeBookDto buildDto(GradeBookEntity entity, boolean all) {
        GradeBookDto dto = new GradeBookDto();
        dto.setId(entity.getId());
        if (entity.getSubject() != null) {
            dto.setSubject(subjectFactory.createMinimalDto(entity.getSubject()));
        }
        if (entity.getTeacher() != null) {
            dto.setTeacher(teacherFactory.createMinimalDto(entity.getTeacher()));
        }
        if (entity.getStudyGroup() != null) {
            dto.setStudyGroup(studyGroupFactory.createMinimalDto(entity.getStudyGroup()));
        }
        if (entity.getActivity() != null && !entity.getActivity().isEmpty()) {
            dto.setActivity(new ArrayList<>());
            for (ActivityEntity activity : entity.getActivity()) {
                dto.getActivity().add(activityFactory.createMinimalDto(activity));
            }
        }
        dto.setGrade(entity.getGrade());
        dto.setSemesterGrade(entity.getSemesterGrade());
        dto.setYearlyGrade(entity.getYearlyGrade());
        return dto;
    }

    @Override
    protected GradeBookEntity createEmptyEntity() {
        return new GradeBookEntity();
    }

    @Override
    protected GradeBookDto createEmptyDto() {
        return new GradeBookDto();
    }

    @Override
    protected void fillEntity(GradeBookDto dto, GradeBookEntity entity) {
        fillEntityWithOnlyId(dto, entity);
        entity.setId(dto.getId());
        if (dto.getSubject() != null) {
            entity.setSubject(subjectFactory.createEntityWithOnlyId(dto.getSubject()));
        }
        if (dto.getTeacher() != null) {
            entity.setTeacher(teacherFactory.createEntityWithOnlyId(dto.getTeacher()));
        }
        if (dto.getStudyGroup() != null) {
            entity.setStudyGroup(studyGroupFactory.createEntityWithOnlyId(dto.getStudyGroup()));
        }
        entity.setGrade(dto.getGrade());
        entity.setSemesterGrade(dto.getSemesterGrade());
        entity.setYearlyGrade(dto.getYearlyGrade());
    }

    @Override
    protected void fillEntityWithOnlyId(GradeBookDto dto, GradeBookEntity entity) {
        entity.setId(dto.getId());
    }

    @Override
    protected GradeBookDto createMinimalDto(GradeBookEntity entity) {
        if (entity == null) return null;
        GradeBookDto dto = new GradeBookDto();
        dto.setId(entity.getId());
        dto.setSubject(subjectFactory.createMinimalDto(entity.getSubject()));
        return dto;
    }

    @Override
    protected GradeBookEntity createMinimalEntity(GradeBookDto dto) {
        if (dto == null) return null;
        GradeBookEntity entity = new GradeBookEntity();
        entity.setId(dto.getId());
        entity.setSubject(subjectFactory.createEntity(dto.getSubject()));
        return entity;
    }
}
