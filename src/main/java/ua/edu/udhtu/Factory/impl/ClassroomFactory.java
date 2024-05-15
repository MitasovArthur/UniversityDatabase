package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.ClassroomDto;
import ua.edu.udhtu.model.dto.StudentDto;
import ua.edu.udhtu.model.entity.ClassroomEntity;
import ua.edu.udhtu.model.entity.StudentEntity;

public class ClassroomFactory extends AbstractTableFactory<ClassroomEntity, ClassroomDto, Long> {
    @Override
    protected ClassroomDto buildDto(ClassroomEntity entity, boolean all) {
        ClassroomDto dto = new ClassroomDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setType(entity.getType());
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
}
