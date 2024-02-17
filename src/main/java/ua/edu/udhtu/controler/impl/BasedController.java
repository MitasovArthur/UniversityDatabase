package ua.edu.udhtu.controler.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.edu.udhtu.Factory.impl.AbstractTableFactory;
import ua.edu.udhtu.controler.ICrudController;
import ua.edu.udhtu.model.dto.BaseDto;
import ua.edu.udhtu.model.entity.BasedEntity;
import ua.edu.udhtu.service.IService;

import java.util.List;


public class BasedController<E extends BasedEntity<I>, D extends BaseDto<I>, I extends Number, F extends AbstractTableFactory<E, D, I>>
        implements ICrudController<E, D, I> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasedController.class);

    protected final Class<E> eClassController;
    protected final Class<D> dtoClassController;
    protected final IService<E, I> service;
    protected final F factory;

    public BasedController(Class<E> eClass, Class<D> dClass, IService<E, I> service, F factory) {
        this.eClassController = eClass;
        this.dtoClassController = dClass;
        this.service = service;
        this.factory = factory;
    }

    @Override
    public List<D> getAll()  {
        LOGGER.info("In getAll " + dtoClassController.getName());
        return factory.createDtoList(service.getAll());
    }

    @Override
    public D getById(I id) {
        if (id == null) {
            LOGGER.warn("In findById [" + eClassController + "] - enter null");
            return null;
        }
        return factory.createDto(service.getById(id));
    }

    @Override
    public void deleteById(I id) {
        if (id == null) {
            LOGGER.warn("In deleteById [" + eClassController + "] - enter null");
        }
        service.deleteById(id);
    }

    @Override
    public D saveOrUpdate(D dto) {
        if (dto == null) {
            LOGGER.warn("In saveOrUpdate [" + eClassController + "] - enter null");
            return null;
        }
        E entity = service.saveOrUpdate(factory.createEntity(dto));
        return factory.createDto(entity);
    }

    protected boolean isNullId(D dto) {
        return false;
    }

    protected I extractKey(D dto) {
        return (I) dto.getId();
    }

    protected void vanishingId(D dto) {
        dto.setId(null);
    }
}
