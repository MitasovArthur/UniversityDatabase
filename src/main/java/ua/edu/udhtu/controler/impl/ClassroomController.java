package ua.edu.udhtu.controler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.udhtu.Factory.impl.ClassroomFactory;
import ua.edu.udhtu.model.dto.ClassroomDto;
import ua.edu.udhtu.model.entity.ClassroomEntity;
import ua.edu.udhtu.service.impl.ClassroomService;

@RestController
@RequestMapping("classroom")
public class ClassroomController extends BasedController<ClassroomEntity, ClassroomDto, Long, ClassroomFactory> {
    @Autowired
    public ClassroomController(ClassroomService service, ClassroomFactory factory) {
        super(ClassroomEntity.class, ClassroomDto.class, service, factory);
    }
}
