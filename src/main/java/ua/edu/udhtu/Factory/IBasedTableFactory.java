package ua.edu.udhtu.Factory;

import java.util.List;

public interface IBasedTableFactory<E, D> {
    List<D> createDtoList(List<E> listEntity, boolean all);

    List<D> createDtoList(List<E> listEntity);

    D createDto(E entity);

    D createDto(E entity, boolean all);

    E createEntity(D dto);

    E createEntityWithOnlyId(D dto);

    void refillEntity(D dto, E entity, boolean onlyId);

}
