package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.SubjectDto;
import ua.edu.udhtu.model.entity.SubjectEntity;

public class SubjectFactory extends AbstractTableFactory<SubjectEntity, SubjectDto, Long> {
    @Override
    protected SubjectDto buildDto(SubjectEntity entity, boolean all) {
        SubjectDto dto = new SubjectDto();
        dto.setId(entity.getId());
        dto.setNameSubject(entity.getNameSubject());
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

    }

    @Override
    protected void fillEntityWithOnlyId(SubjectDto dto, SubjectEntity entity) {
        entity.setId(dto.getId());
        entity.setNameSubject(dto.getNameSubject());
        entity.setHourSubject(dto.getHourSubject());
    }
}
