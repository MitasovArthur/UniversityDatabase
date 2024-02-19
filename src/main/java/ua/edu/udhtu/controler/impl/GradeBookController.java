package ua.edu.udhtu.controler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.udhtu.Factory.impl.GradeBookFactory;
import ua.edu.udhtu.model.dto.GradeBookDto;
import ua.edu.udhtu.model.entity.GradeBookEntity;
import ua.edu.udhtu.service.IService;
import ua.edu.udhtu.service.impl.GradeBookService;

@RestController
@RequestMapping("gradeBook")
public class GradeBookController extends BasedController<GradeBookEntity, GradeBookDto, Long, GradeBookFactory> {
    @Autowired
    public GradeBookController(GradeBookService service, GradeBookFactory factory) {
        super(GradeBookEntity.class, GradeBookDto.class, service, factory);
    }
}
