package ua.edu.udhtu.controler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.udhtu.Factory.impl.SubjectFactory;
import ua.edu.udhtu.model.dto.SubjectDto;
import ua.edu.udhtu.model.entity.SubjectEntity;
import ua.edu.udhtu.model.entity.TeacherEntity;
import ua.edu.udhtu.repository.SubjectRepository;
import ua.edu.udhtu.repository.TeacherRepository;
import ua.edu.udhtu.service.impl.SubjectService;

@RestController
@RequestMapping("subject")
public class SubjectController extends BasedController<SubjectEntity, SubjectDto, Long, SubjectFactory> {
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public SubjectController(SubjectService service, SubjectFactory factory, SubjectRepository subjectRepository, TeacherRepository teacherRepository) {
        super(SubjectEntity.class, SubjectDto.class, service, factory);
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    @PutMapping("/{idSubject}/teacher/{idTeacher}")
    public ResponseEntity<Void> addSubjectToTeacher(@PathVariable Long idSubject, @PathVariable Long idTeacher) {
        SubjectEntity subjectEntity = subjectRepository.findById(idSubject).orElse(null);
        TeacherEntity teacher = teacherRepository.findById(idTeacher).orElse(null);
        if (subjectEntity == null || teacher == null) {
            return ResponseEntity.notFound().build();
        }
        subjectEntity.getTeachers().add(teacher);
        teacher.getSubjects().add(subjectEntity);  // Ensure both sides are synchronized
        subjectRepository.save(subjectEntity);
        teacherRepository.save(teacher);  // Save teacher as well
        return ResponseEntity.ok().build();
    }
}
