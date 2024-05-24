package ua.edu.udhtu.controler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.udhtu.Factory.impl.ClassroomFactory;
import ua.edu.udhtu.model.dto.ClassroomDto;
import ua.edu.udhtu.model.entity.ActivityEntity;
import ua.edu.udhtu.model.entity.ClassroomEntity;
import ua.edu.udhtu.model.entity.StudentEntity;
import ua.edu.udhtu.model.entity.TimetableOfClassesEntity;
import ua.edu.udhtu.repository.ClassroomRepository;
import ua.edu.udhtu.repository.TimeTableOfClassRepository;
import ua.edu.udhtu.service.impl.ClassroomService;

import java.util.Optional;

@RestController
@RequestMapping("classroom")
public class ClassroomController extends BasedController<ClassroomEntity, ClassroomDto, Long, ClassroomFactory> {
    private final ClassroomRepository classroomRepository;
    private final TimeTableOfClassRepository timeTableOfClassRepository;

    @Autowired
    public ClassroomController(ClassroomService service, ClassroomFactory factory, ClassroomRepository classroomRepository, TimeTableOfClassRepository timeTableOfClassRepository) {
        super(ClassroomEntity.class, ClassroomDto.class, service, factory);
        this.classroomRepository = classroomRepository;
        this.timeTableOfClassRepository = timeTableOfClassRepository;
    }

    @PutMapping("/{idClassroom}/timeTableOfClass/{idTimeTableOfClass}")
    public ResponseEntity<Void> addActivityToStudent(@PathVariable Long idClassroom, @PathVariable Long idTimeTableOfClass) {
        ClassroomEntity classroomEntity = classroomRepository.findById(idClassroom).orElse(null);
        TimetableOfClassesEntity timeTableOfClassEntity = timeTableOfClassRepository.findById(idTimeTableOfClass).orElse(null);
        if (classroomEntity == null || timeTableOfClassEntity == null) {
            return ResponseEntity.notFound().build();
        }
        classroomEntity.getTimetableOfClasses().add(timeTableOfClassEntity);
        classroomRepository.save(classroomEntity);
        return ResponseEntity.ok().build();
    }
}
