package ua.edu.udhtu.controler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.udhtu.Factory.impl.PersonFactory;
import ua.edu.udhtu.model.dto.PersonDto;
import ua.edu.udhtu.model.entity.PersonEntity;
import ua.edu.udhtu.service.impl.PersonService;

@RestController
@RequestMapping("person")
public class PersonController extends BasedController<PersonEntity, PersonDto, Long, PersonFactory> {
    @Autowired
    public PersonController(PersonService service, PersonFactory factory) {
        super(PersonEntity.class, PersonDto.class, service, factory);
    }
}
