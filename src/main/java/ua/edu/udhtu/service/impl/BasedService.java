package ua.edu.udhtu.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.udhtu.model.entity.BasedEntity;
import ua.edu.udhtu.service.IService;

import java.util.List;
import java.util.Optional;

public class BasedService<E extends BasedEntity<I>, I extends Number>
        implements IService<E, I> {

    protected final static Logger LOGGER = LoggerFactory.getLogger(BasedService.class);

    protected final Class<E> eClassService;
    protected final JpaRepository<E, I> repository;

    public BasedService(Class<E> eClassService, JpaRepository<E, I> repository) {
        this.eClassService = eClassService;
        this.repository = repository;
    }

    @Override
    public List<E> getAll( ) {
    return repository.findAll();
    }

    @Override
    public E getById(I id) {
        LOGGER.info("In findById [" + eClassService + "] search by ID {}", id);
        if (id == null) {
            return null;
        }
        Optional<E> optional = repository.findById(id);
        if (optional.isPresent()) {
            LOGGER.info("In findById [" + eClassService + "] entity found {}", optional.get());
            return optional.get();
        } else {
            LOGGER.warn("In findById [" + eClassService + "] entity with {id = " + id + "} does not exist in the database");
            return null;
        }
    }

    @Override
    public void deleteById(I id) {
        LOGGER.warn("In deleteById [" + eClassService + "] delete by ID {}", id);
        if (id != null) {
            repository.deleteById(id);
            LOGGER.info("In deleteById [" + eClassService + "] entity {id = " + id + "} delete");
        } else {
            LOGGER.warn("In deleteById [" + eClassService + "] imposable delete entity {id = null }");
        }
    }

    @Override
    public E saveOrUpdate(E entity) {
        LOGGER.info("In saveOrUpdate [" + eClassService + "] save a new entity");
        E savedEntity = repository.save(entity);
        LOGGER.info("In save [" + eClassService + "] save entity : {}", savedEntity);
        return savedEntity;
    }
}
