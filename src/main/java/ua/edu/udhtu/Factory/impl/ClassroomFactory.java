package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.ClassroomDto;
import ua.edu.udhtu.model.dto.StudentDto;
import ua.edu.udhtu.model.dto.TimetableOfClassesDto;
import ua.edu.udhtu.model.entity.ClassroomEntity;
import ua.edu.udhtu.model.entity.StudentEntity;
import ua.edu.udhtu.model.entity.TimetableOfClassesEntity;

import java.util.ArrayList;

public class ClassroomFactory extends AbstractTableFactory<ClassroomEntity, ClassroomDto, Long> {
    private AbstractTableFactory<TimetableOfClassesEntity, TimetableOfClassesDto, Long> timeTableOfClassFactory;

    public void setTimeTableOfClassFactory(AbstractTableFactory<TimetableOfClassesEntity, TimetableOfClassesDto, Long> timeTableOfClassFactory) {
        this.timeTableOfClassFactory = timeTableOfClassFactory;
    }

    @Override
    protected ClassroomDto buildDto(ClassroomEntity entity, boolean all) {
        ClassroomDto dto = new ClassroomDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setType(entity.getType());
        if (entity.getTimetableOfClasses() != null && !entity.getTimetableOfClasses().isEmpty()) {
            dto.setTimetableOfClasses(new ArrayList<>());
            for (TimetableOfClassesEntity timetableOfClasses : entity.getTimetableOfClasses()) {
                dto.getTimetableOfClasses().add(timeTableOfClassFactory.createMinimalDto(timetableOfClasses));
            }
        }
        return dto;
    }

    @Override
    protected ClassroomEntity createEmptyEntity() {
        return new ClassroomEntity();
    }

    @Override
    protected ClassroomDto createEmptyDto() {
        return new ClassroomDto();
    }

    @Override
    protected void fillEntity(ClassroomDto dto, ClassroomEntity entity) {
        fillEntityWithOnlyId(dto, entity);
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setType(dto.getType());
    }

    @Override
    protected void fillEntityWithOnlyId(ClassroomDto dto, ClassroomEntity entity) {
        entity.setId(dto.getId());
    }

    @Override
    protected ClassroomDto createMinimalDto(ClassroomEntity studyGroupEntity) {
        if (studyGroupEntity == null) return null;
        ClassroomDto classroomDto = new ClassroomDto();
        classroomDto.setId(studyGroupEntity.getId());
        classroomDto.setCode(studyGroupEntity.getCode());
        classroomDto.setType(studyGroupEntity.getType());
        return classroomDto;
    }

    @Override
    protected ClassroomEntity createMinimalEntity(ClassroomDto studyGroupDto) {
        if (studyGroupDto == null) return null;
        ClassroomEntity entity = new ClassroomEntity();
        entity.setId(studyGroupDto.getId());
        entity.setCode(studyGroupDto.getCode());
        entity.setType(studyGroupDto.getType());
        return entity;
    }
}
