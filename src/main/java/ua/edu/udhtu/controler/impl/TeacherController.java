package ua.edu.udhtu.controler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import ua.edu.udhtu.Factory.impl.TeacherFactory;
import ua.edu.udhtu.model.dto.SubjectDto;
import ua.edu.udhtu.model.dto.TeacherDto;
import ua.edu.udhtu.model.entity.SubjectEntity;
import ua.edu.udhtu.model.entity.TeacherEntity;
import ua.edu.udhtu.service.IService;
import ua.edu.udhtu.service.impl.SubjectService;
import ua.edu.udhtu.service.impl.TeacherService;

@RestController
@RequestMapping("teacher")
public class TeacherController extends BasedController<TeacherEntity, TeacherDto, Long, TeacherFactory> {
    @Autowired
    public TeacherController(TeacherService service, TeacherFactory factory) {
        super(TeacherEntity.class, TeacherDto.class, service, factory);
    }

//    @Autowired
//    private SubjectService subjectService;
//
//    @PostMapping("/{teacherId}/addSubject")
//    public ResponseEntity<?> addSubjectToTeacher(@PathVariable Long teacherId, @RequestBody SubjectDto subjectDto) {
//        TeacherEntity teacherEntity = service.getById(teacherId);
//        if (teacherEntity == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        SubjectEntity subjectEntity = subjectService.createEntity(subjectDto); // Створюємо сутність предмета
//
//        // Додаємо предмет до вчителя
//        teacherEntity.getSubjects().add(subjectEntity);
//        service.saveOrUpdate(teacherEntity);
//
//        return ResponseEntity.ok().build();
    }

