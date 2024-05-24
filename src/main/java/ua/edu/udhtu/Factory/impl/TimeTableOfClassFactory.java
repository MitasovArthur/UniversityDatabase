package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.*;
import ua.edu.udhtu.model.entity.*;

public class TimeTableOfClassFactory extends AbstractTableFactory<TimetableOfClassesEntity, TimetableOfClassesDto, Long> {
    private AbstractTableFactory<TeacherEntity, TeacherDto, Long> teacherFactory;
    private AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> studyGroupFactory;
    private AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory;
    private AbstractTableFactory<ClassroomEntity, ClassroomDto, Long> classroomFactory;

    public void setTeacherFactory(AbstractTableFactory<TeacherEntity, TeacherDto, Long> teacherFactory) {
        this.teacherFactory = teacherFactory;
    }

    public void setStudyGroupFactory(AbstractTableFactory<StudyGroupEntity, StudyGroupDto, Long> studyGroupFactory) {
        this.studyGroupFactory = studyGroupFactory;
    }

    public void setSubjectFactory(AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory) {
        this.subjectFactory = subjectFactory;
    }

    public void setClassroomFactory(AbstractTableFactory<ClassroomEntity, ClassroomDto, Long> classroomFactory) {
        this.classroomFactory = classroomFactory;
    }

    @Override
    protected TimetableOfClassesDto buildDto(TimetableOfClassesEntity entity, boolean all) {
        TimetableOfClassesDto dto = new TimetableOfClassesDto();
        dto.setId(entity.getId());
        if (entity.getTeacher() != null) {
            dto.setTeacher(teacherFactory.createMinimalDto(entity.getTeacher()));
        }
        if (entity.getStudyGroup() != null) {
            dto.setStudyGroup(studyGroupFactory.createMinimalDto(entity.getStudyGroup()));
        }
        if (entity.getSubject() != null) {
            dto.setSubject(subjectFactory.createMinimalDto(entity.getSubject()));
        }
        if (entity.getClassRoom() != null) {
            dto.setClassroomDto(classroomFactory.createMinimalDto(entity.getClassRoom()));
        }
        dto.setStartLesson(entity.getStartLesson());
        dto.setEndLesson(entity.getEndLesson());
        return dto;
    }

    @Override
    protected TimetableOfClassesEntity createEmptyEntity() {
        return new TimetableOfClassesEntity();
    }

    @Override
    protected TimetableOfClassesDto createEmptyDto() {
        return new TimetableOfClassesDto();
    }

    @Override
    protected void fillEntity(TimetableOfClassesDto dto, TimetableOfClassesEntity entity) {
        fillEntityWithOnlyId(dto, entity);
        if (dto.getTeacher() != null) {
            entity.setTeacher(teacherFactory.createEntityWithOnlyId(dto.getTeacher()));
        }
        if (dto.getStudyGroup() != null) {
            entity.setStudyGroup(studyGroupFactory.createEntityWithOnlyId(dto.getStudyGroup()));
        }
        if (dto.getSubject() != null) {
            entity.setSubject(subjectFactory.createEntityWithOnlyId(dto.getSubject()));
        }
        if (dto.getClassroomDto() != null) {
            entity.setClassRoom(classroomFactory.createEntityWithOnlyId(dto.getClassroomDto()));
        }
        entity.setStartLesson(dto.getStartLesson());
        entity.setEndLesson(dto.getEndLesson());
    }

    @Override
    protected void fillEntityWithOnlyId(TimetableOfClassesDto dto, TimetableOfClassesEntity entity) {
        entity.setId(dto.getId());
    }

    @Override
    protected TimetableOfClassesDto createMinimalDto(TimetableOfClassesEntity entity) {
        if (entity == null) return null;
        TimetableOfClassesDto dto = new TimetableOfClassesDto();
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    protected TimetableOfClassesEntity createMinimalEntity(TimetableOfClassesDto dto) {
        if (dto == null) return null;
        TimetableOfClassesEntity entity = new TimetableOfClassesEntity();
        entity.setId(dto.getId());
        return entity;
    }
}
