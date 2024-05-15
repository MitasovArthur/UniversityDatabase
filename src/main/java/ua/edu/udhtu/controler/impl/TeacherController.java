package ua.edu.udhtu.controler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ua.edu.udhtu.Factory.impl.TeacherFactory;
import ua.edu.udhtu.model.dto.SubjectDto;
import ua.edu.udhtu.model.dto.TeacherDto;
import ua.edu.udhtu.model.entity.SubjectEntity;
import ua.edu.udhtu.model.entity.TeacherEntity;
import ua.edu.udhtu.repository.SubjectRepository;
import ua.edu.udhtu.repository.TeacherRepository;
import ua.edu.udhtu.service.IService;
import ua.edu.udhtu.service.impl.SubjectService;
import ua.edu.udhtu.service.impl.TeacherService;

import java.util.Optional;

@RestController
@RequestMapping("teacher")
public class TeacherController extends BasedController<TeacherEntity, TeacherDto, Long, TeacherFactory> {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherService service, TeacherFactory factory) {
        super(TeacherEntity.class, TeacherDto.class, service, factory);
    }

    @PutMapping("/{idTeacher}/subjects/{idSubject}")
    public ResponseEntity<Void> addSubjectToTeacher(@PathVariable Long idSubject, @PathVariable Long idTeacher) {
        TeacherEntity teacher = teacherRepository.findById(idTeacher).orElse(null);
        SubjectEntity subject = subjectRepository.findById(idSubject).orElse(null);

        if (teacher == null || subject == null) {
            return ResponseEntity.notFound().build();
        }

        boolean isAdded = teacher.getSubjects().add(subject);
        if (isAdded) {
            teacherRepository.save(teacher);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

