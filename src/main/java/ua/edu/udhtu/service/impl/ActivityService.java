package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.ActivityEntity;
import ua.edu.udhtu.model.entity.GradeBookEntity;
import ua.edu.udhtu.model.entity.StudentEntity;
import ua.edu.udhtu.model.entity.SubjectEntity;
import ua.edu.udhtu.repository.ActivityRepository;
import ua.edu.udhtu.repository.GradeBookRepository;
import ua.edu.udhtu.repository.StudentRepository;
import ua.edu.udhtu.repository.SubjectRepository;

import java.util.Objects;
import java.util.Optional;

@Service
public class ActivityService extends BasedService<ActivityEntity, Long> {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final GradeBookRepository gradeBookRepository;

    @Autowired
    public ActivityService(ActivityRepository repository, StudentRepository studentRepository, SubjectRepository subjectRepository, GradeBookRepository gradeBookRepository) {
        super(ActivityEntity.class, repository);
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.gradeBookRepository = gradeBookRepository;
    }

    @Override
    protected void fillEntity(ActivityEntity loadFromDb, ActivityEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setId(fromClient.getId());
            if (fromClient.getSubject() != null) {
                if (fromClient.getSubject().getId() != null) {
                    if (loadFromDb.getSubject() == null || !Objects.equals(loadFromDb.getSubject().getId(), fromClient.getSubject().getId())) {
                        Optional<SubjectEntity> subject = subjectRepository.findById(fromClient.getSubject().getId());
                        if (subject.isPresent()) {
                            loadFromDb.setSubject(subject.get());
                        } else {
                            throw new IllegalStateException("Subject with id " + fromClient.getStudent().getId() + " is already assigned as a curator to another group.");
                        }
                    }
                }
            }

            loadFromDb.setNameActivity(fromClient.getNameActivity());
            loadFromDb.setDescription(fromClient.getDescription());
            loadFromDb.setDeadLine(fromClient.getDeadLine());
            loadFromDb.setGrade(fromClient.getGrade());

            if (fromClient.getStudent() != null) {
                if (fromClient.getStudent().getId() != null) {
                    if (loadFromDb.getStudent() == null || !Objects.equals(loadFromDb.getStudent().getId(), fromClient.getStudent().getId())) {
                        Optional<StudentEntity> student = studentRepository.findById(fromClient.getStudent().getId());
                        if (student.isPresent()) {
                            loadFromDb.setStudent(student.get());
                        } else {
                            throw new IllegalStateException("Teacher with id " + fromClient.getStudent().getId() + " is already assigned as a curator to another group.");
                        }
                    }
                }
            }

            if (fromClient.getGradeBook() != null) {
                if (fromClient.getGradeBook().getId() != null) {
                    if (loadFromDb.getGradeBook() == null || !Objects.equals(loadFromDb.getGradeBook().getId(), fromClient.getGradeBook().getId())) {
                        Optional<GradeBookEntity> gradeBook = gradeBookRepository.findById(fromClient.getGradeBook().getId());
                        if (gradeBook.isPresent()) {
                            loadFromDb.setGradeBook(gradeBook.get());
                        } else {
                            throw new IllegalStateException("Teacher with id " + fromClient.getStudent().getId() + " is already assigned as a curator to another group.");
                        }
                    }
                }
            }

            repository.save(loadFromDb);
        }
    }

    @Override
    protected ActivityEntity createEmptyEntity() {
        return new ActivityEntity();
    }
}
