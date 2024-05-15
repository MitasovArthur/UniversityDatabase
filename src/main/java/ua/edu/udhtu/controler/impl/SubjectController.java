package ua.edu.udhtu.controler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.udhtu.Factory.impl.SubjectFactory;
import ua.edu.udhtu.model.dto.SubjectDto;
import ua.edu.udhtu.model.entity.SubjectEntity;
import ua.edu.udhtu.service.impl.SubjectService;

@RestController
@RequestMapping("subject")
public class SubjectController extends BasedController<SubjectEntity, SubjectDto, Long, SubjectFactory> {
    @Autowired
    public SubjectController(SubjectService service, SubjectFactory factory) {
        super(SubjectEntity.class, SubjectDto.class, service, factory);
    }
}
