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

    private final StudentRepository studentRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public StudentController(StudentService service, StudentFactory factory, StudentRepository studentRepository, ActivityRepository activityRepository) {
        super(StudentEntity.class, StudentDto.class, service, factory);
        this.studentRepository = studentRepository;
        this.activityRepository = activityRepository;
    }
//
//    @PutMapping("/{idStudent}/activity/{idActivity}")
//    public ResponseEntity<Void> addActivityToStudent(@PathVariable Long idStudent, @PathVariable Long idActivity) {
//        StudentEntity studentEntity = studentRepository.findById(idStudent).orElse(null);
//        ActivityEntity activityEntity = activityRepository.findById(idActivity).orElse(null);
//        if (studentEntity == null || activityEntity == null) {
//            return ResponseEntity.notFound().build();
//        }
//        studentEntity.getActivity().add(activityEntity);
//        studentRepository.save(studentEntity);
//        return ResponseEntity.ok().build();
//    }

}