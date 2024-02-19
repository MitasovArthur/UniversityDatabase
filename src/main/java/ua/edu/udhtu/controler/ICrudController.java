package ua.edu.udhtu.controler;

import org.springframework.web.bind.annotation.*;
import ua.edu.udhtu.model.dto.BaseDto;

import java.util.List;

public interface ICrudController<D extends BaseDto<I>, I> {

    @GetMapping
    List<D> getAll();

    @GetMapping("{id}")
    D getById(@PathVariable("id") I id);

    @DeleteMapping("{id}")
    void deletById(@PathVariable("id") I id);

    @PostMapping()
    D saverOrUpdate(@RequestBody D dto);
}
//public interface ICrudController<E extends BasedEntity<I>, D extends BaseDto<I>, I extends Number> {
//
//    @GetMapping
//    List<D> getAll();
//
//    @GetMapping("{id}")
//    D getById(@PathVariable("{id}") I id);
//
//    @DeleteMapping("{id}")
//    void deleteById(@PathVariable("{id}") I id);
//
//    @PostMapping
//    D saveOrUpdate(@RequestBody D dto);
//}
