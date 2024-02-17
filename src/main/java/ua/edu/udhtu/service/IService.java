package ua.edu.udhtu.service;

import org.springframework.web.bind.annotation.*;
import ua.edu.udhtu.model.entity.BasedEntity;

import java.util.List;

public interface IService<E extends BasedEntity<I>, I extends Number> {
    @GetMapping
    List<E> getAll();

    @GetMapping("/{id}")
    E getById(@PathVariable I id);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable I id);

    @PostMapping
    E saveOrUpdate(@RequestBody E entity);
}
