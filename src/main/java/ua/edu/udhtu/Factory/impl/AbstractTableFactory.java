package ua.edu.udhtu.Factory.impl;

import ua.edu.udhtu.Factory.IBasedTableFactory;
import ua.edu.udhtu.model.dto.BaseDto;
import ua.edu.udhtu.model.entity.BasedEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTableFactory<E extends BasedEntity<I>, D extends BaseDto<I>, I extends Number>
        implements IBasedTableFactory<E, D> {
    public AbstractTableFactory() {
    }

    /**
     * --------------------------------------------DTO-----------------------------------------------------
     */

    @Override
    public List<D> createDtoList(List<E> listEntity, boolean all) {
        if (listEntity == null || listEntity.isEmpty()) {
            return new ArrayList<>(0);
        }

        List<D> listDto = new ArrayList<>(listEntity.size());

        listEntity.forEach(e -> listDto.add(createDto(e, all)));

        return listDto;
    }

    @Override
    public List<D> createDtoList(List<E> listEntity) {
        return createDtoList(listEntity, true);
    }

    @Override
    public D createDto(E entity) {
        return createDto(entity, true);
    }

    @Override
    public D createDto(E entity, boolean all) {
        if (entity == null) return null;
        return buildDto(entity, all);
    }

    protected abstract D buildDto(E entity, boolean all);

    /**
     * --------------------------------------------Entity-----------------------------------------------------
     */
    protected abstract E createEmptyEntity();
    protected abstract D createEmptyDto();
    @Override
    public E createEntity(D dto) {
        if (dto == null) {
            return null;
        }
        E entity = createEmptyEntity();
        fillEntity(dto, entity);
        return entity;
    }


    @Override
    public E createEntityWithOnlyId(D dto) {
        if (dto == null) {
            return null;
        }
        E entity = createEmptyEntity();
        fillEntityWithOnlyId(dto, entity);
        return entity;
    }

    @Override
    public void refillEntity(D dto, E entity, boolean onlyId) {
        if (dto == null || entity == null) return;
        if (onlyId) {
            fillEntityWithOnlyId(dto, entity);
        } else {
            fillEntity(dto, entity);
        }
    }

    protected abstract void fillEntity(D dto, E entity);

    protected abstract void fillEntityWithOnlyId(D dto, E entity);

    protected abstract D createMinimalDto(E studyGroup);
}
