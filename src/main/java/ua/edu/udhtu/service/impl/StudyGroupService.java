package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.GradeBookEntity;
import ua.edu.udhtu.model.entity.StudyGroupEntity;
import ua.edu.udhtu.model.entity.TeacherEntity;
import ua.edu.udhtu.repository.GradeBookRepository;
import ua.edu.udhtu.repository.StudyGroupRepository;
import ua.edu.udhtu.repository.TeacherRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudyGroupService extends BasedService<StudyGroupEntity, Long> {
    private final TeacherRepository teacherRepository;
    private final GradeBookRepository gradeBookRepository;

    @Autowired
    public StudyGroupService(StudyGroupRepository repository, TeacherRepository teacherRepository, GradeBookRepository gradeBookRepository) {
        super(StudyGroupEntity.class, repository);
        this.teacherRepository = teacherRepository;
        this.gradeBookRepository = gradeBookRepository;
    }

    @Override
    protected void fillEntity(StudyGroupEntity loadFromDb, StudyGroupEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setId(fromClient.getId());
            loadFromDb.setCode(fromClient.getCode());

            if (fromClient.getCurator() != null) {
                if (fromClient.getCurator().getId() != null) {
                    if (loadFromDb.getCurator() == null || !Objects.equals(loadFromDb.getCurator().getId(), fromClient.getCurator().getId())) {
                        Optional<TeacherEntity> teacher = teacherRepository.findById(fromClient.getCurator().getId());
                        if (teacher.isPresent()) {
                            TeacherEntity foundTeacher = teacher.get();
                            if (foundTeacher.getStudyGroup() == null) {
                                loadFromDb.setCurator(foundTeacher);
                            } else {
                                throw new IllegalStateException("Teacher with id " + fromClient.getCurator().getId() + " is already assigned as a curator to another group.");
                            }
                        } else {
                            throw new EntityNotFoundException("Teacher with id " + fromClient.getCurator().getId() + " not found");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Curator ID must be provided.");
                }
            }

            if (fromClient.getGradeBook() != null) {
                if (fromClient.getGradeBook().getId() != null) {
                    if (loadFromDb.getGradeBook() == null || !Objects.equals(loadFromDb.getGradeBook().getId(), fromClient.getGradeBook().getId())) {
                        Optional<GradeBookEntity> gradeBook = gradeBookRepository.findById(fromClient.getGradeBook().getId());
                        if (gradeBook.isPresent()) {
                            loadFromDb.setGradeBook(gradeBook.get());
                        } else {
                            throw new EntityNotFoundException("GradeBook with id " + fromClient.getGradeBook().getId() + " not found");
                        }
                    }
                } else {
                    throw new EntityNotFoundException("GradeBook id is null");
                }
            }
            repository.save(loadFromDb);
        }
    }

    @Override
    protected StudyGroupEntity createEmptyEntity() {
        return new StudyGroupEntity();
    }
}
