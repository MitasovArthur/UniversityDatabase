package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.GradeBookEntity;
import ua.edu.udhtu.model.entity.StudyGroupEntity;
import ua.edu.udhtu.model.entity.SubjectEntity;
import ua.edu.udhtu.model.entity.TeacherEntity;
import ua.edu.udhtu.repository.GradeBookRepository;
import ua.edu.udhtu.repository.StudyGroupRepository;
import ua.edu.udhtu.repository.SubjectRepository;
import ua.edu.udhtu.repository.TeacherRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;

@Service
public class GradeBookService extends BasedService<GradeBookEntity, Long> {
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;
    private final StudyGroupRepository studyGroupRepository;

    @Autowired
    public GradeBookService(GradeBookRepository repository, SubjectRepository subjectRepository, TeacherRepository teacherRepository, StudyGroupRepository studyGroupRepository) {
        super(GradeBookEntity.class, repository);
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
        this.studyGroupRepository = studyGroupRepository;
    }

    @Override
    protected void fillEntity(GradeBookEntity loadFromDb, GradeBookEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setId(fromClient.getId());
            loadFromDb.setSubject(fromClient.getSubject());
            if (loadFromDb.getSubject() == null || !Objects.equals(loadFromDb.getSubject().getId(), fromClient.getSubject().getId())) {
                Optional<SubjectEntity> subject = subjectRepository.findById(fromClient.getSubject().getId());
                {
                    if (subject.isPresent()) {
                        loadFromDb.setSubject(subject.get());
                    } else {
                        throw new EntityNotFoundException("Subject with id " + fromClient.getSubject().getId() + " not found");
                    }
                }
            }
            if (loadFromDb.getTeacher() == null || !Objects.equals(loadFromDb.getTeacher().getId(), fromClient.getTeacher().getId())) {
                Optional<TeacherEntity> teacher = teacherRepository.findById(fromClient.getTeacher().getId());
                {
                    if (teacher.isPresent()) {
                        loadFromDb.setTeacher(teacher.get());
                    } else {
                        throw new EntityNotFoundException("Teacher with id " + fromClient.getSubject().getId() + " not found");
                    }
                }
            }

            if (fromClient.getStudyGroup().getId() != null) {
                if (loadFromDb.getStudyGroup() == null || !Objects.equals(loadFromDb.getStudyGroup().getId(), fromClient.getStudyGroup().getId())) {
                    Optional<StudyGroupEntity> studyGroup = studyGroupRepository.findById(fromClient.getStudyGroup().getId());
                    if (studyGroup.isPresent()) {
                        StudyGroupEntity foundStudyGroup = studyGroup.get();
                        if (foundStudyGroup.getGradeBook() == null) {
                            loadFromDb.setStudyGroup(foundStudyGroup);
                        } else {
                            throw new IllegalStateException("Teacher with id " + fromClient.getStudyGroup().getId() + " is already assigned as a curator to another group.");
                        }
                    } else {
                        throw new EntityNotFoundException("Teacher with id " + fromClient.getStudyGroup().getId() + " not found");
                    }
                }
            } else {
                throw new IllegalArgumentException("Curator ID must be provided.");
            }

            loadFromDb.setGrade(fromClient.getGrade());
            loadFromDb.setSemesterGrade(fromClient.getSemesterGrade());
            loadFromDb.setYearlyGrade(fromClient.getYearlyGrade());
            repository.save(loadFromDb);
        }
    }

    @Override
    protected GradeBookEntity createEmptyEntity() {
        return new GradeBookEntity();
    }
}
