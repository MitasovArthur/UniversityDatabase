package ua.edu.udhtu.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.edu.udhtu.Factory.PersonFactory;
import ua.edu.udhtu.controler.impl.BasedController;
import ua.edu.udhtu.model.dto.PersonDto;
import ua.edu.udhtu.model.entity.PersonEntity;
import ua.edu.udhtu.service.PersonService;

@Controller
@RequestMapping("person")
public class PersonController extends BasedController<PersonEntity, PersonDto, Long, PersonFactory> {
    @Autowired
    public PersonController(PersonService service, PersonFactory factory) {
        super(PersonEntity.class, PersonDto.class, service, factory);
    }
}
