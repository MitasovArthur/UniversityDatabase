package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.model.dto.SubjectDto;
import ua.edu.udhtu.model.entity.SubjectEntity;

public class SubjectFactory extends AbstractTableFactory<SubjectEntity, SubjectDto,Long> {
    @Override
    protected SubjectDto buildDto(SubjectEntity entity, boolean all) {
        return null;
    }

    @Override
    protected SubjectEntity createEmptyEntity() {
        return null;
    }

    @Override
    protected SubjectDto createEmptyDto() {
        return null;
    }

    @Override
    protected void fillEntity(SubjectDto dto, SubjectEntity entity) {

    }

    @Override
    protected void fillEntityWithOnlyId(SubjectDto dto, SubjectEntity entity) {

    }
}
