package ua.edu.udhtu.Factory.impl;

import org.springframework.stereotype.Component;
import ua.edu.udhtu.model.dto.ActivityDto;
import ua.edu.udhtu.model.entity.ActivityEntity;

@Component
public class ActivityFactory extends AbstractTableFactory<ActivityEntity, ActivityDto, Long> {
    @Override
    protected ActivityDto buildDto(ActivityEntity entity, boolean all) {
        ActivityDto dto = new ActivityDto();
        dto.setId(entity.getId());
        dto.setNameActivity(entity.getNameActivity());
        dto.setDescription(entity.getDescription());
        dto.setDeadLine(entity.getDeadLine());
        dto.setGrade(entity.getGrade());
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
        entity.setNameActivity(dto.getNameActivity());
        entity.setDescription(dto.getDescription());
        entity.setDeadLine(dto.getDeadLine());
        entity.setGrade(dto.getGrade());
    }

    @Override
    protected void fillEntityWithOnlyId(ActivityDto dto, ActivityEntity entity) {
        entity.setId(dto.getId());
    }
}
