package ua.edu.udhtu.controler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.udhtu.Factory.impl.StudentFactory;
import ua.edu.udhtu.model.dto.StudentDto;
import ua.edu.udhtu.model.entity.StudentEntity;
import ua.edu.udhtu.repository.ActivityRepository;
import ua.edu.udhtu.repository.StudentRepository;
import ua.edu.udhtu.service.impl.StudentService;

@RestController
@RequestMapping("student")
public class StudentController extends BasedController<StudentEntity, StudentDto, Long, StudentFactory> {
    @Autowired
    public StudentController(StudentService service, StudentFactory factory) {
        super(StudentEntity.class, StudentDto.class, service, factory);

    }

}