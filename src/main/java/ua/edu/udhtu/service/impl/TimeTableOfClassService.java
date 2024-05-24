package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.*;
import ua.edu.udhtu.repository.*;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class TimeTableOfClassService extends BasedService<TimetableOfClassesEntity, Long> {
    private final TeacherRepository teacherRepository;
    private final StudyGroupRepository studyGroupRepository;
    private final SubjectRepository subjectRepository;
    private final ClassroomRepository classroomRepository;

    @Autowired
    public TimeTableOfClassService(TimeTableOfClassRepository repository, TeacherRepository teacherRepository, StudyGroupRepository studyGroupRepository, SubjectRepository subjectRepository, ClassroomRepository classroomRepository) {
        super(TimetableOfClassesEntity.class, repository);
        this.teacherRepository = teacherRepository;
        this.studyGroupRepository = studyGroupRepository;
        this.subjectRepository = subjectRepository;
        this.classroomRepository = classroomRepository;
    }

    protected void fillEntity(TimetableOfClassesEntity loadFromDb, TimetableOfClassesEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setId(fromClient.getId());
            loadFromDb.setStartLesson(fromClient.getStartLesson());
            loadFromDb.setEndLesson(fromClient.getEndLesson());

            if (fromClient.getTeacher() != null) {
                if (fromClient.getTeacher().getId() != null) {
                    if (loadFromDb.getTeacher() == null || !Objects.equals(loadFromDb.getTeacher().getId(), fromClient.getTeacher().getId())) {
                        Optional<TeacherEntity> teacher = teacherRepository.findById(fromClient.getTeacher().getId());
                        if (teacher.isPresent()) {
                            loadFromDb.setTeacher(teacher.get());
                        } else {
                            throw new EntityNotFoundException("Teacher with id " + fromClient.getTeacher().getId() + " not found");
                        }
                    }
                } else {
                    throw new EntityNotFoundException("Teacher with id " + fromClient.getTeacher().getId() + " not found");
                }
            }

            if (fromClient.getStudyGroup() != null) {
                if (fromClient.getStudyGroup().getId() != null) {
                    if (loadFromDb.getStudyGroup() == null || !Objects.equals(loadFromDb.getStudyGroup().getId(), fromClient.getStudyGroup().getId())) {
                        Optional<StudyGroupEntity> group = studyGroupRepository.findById(fromClient.getStudyGroup().getId());
                        if (group.isPresent()) {
                            loadFromDb.setStudyGroup(group.get());
                        } else {
                            throw new EntityNotFoundException("StudyGroup with id " + fromClient.getStudyGroup().getId() + " not found");
                        }
                    }
                } else {
                    throw new EntityNotFoundException("StudyGroup with id " + fromClient.getStudyGroup().getId() + " not found");
                }
            }

            if (fromClient.getSubject() != null) {
                if (fromClient.getSubject().getId() != null) {
                    if (loadFromDb.getSubject() == null || !Objects.equals(loadFromDb.getSubject().getId(), fromClient.getSubject().getId())) {
                        Optional<SubjectEntity> subject = subjectRepository.findById(fromClient.getSubject().getId());
                        if (subject.isPresent()) {
                            loadFromDb.setSubject(subject.get());
                        } else {
                            throw new EntityNotFoundException("Subject with id " + fromClient.getSubject().getId() + " not found");
                        }
                    }
                } else {
                    throw new EntityNotFoundException("Subject with id " + fromClient.getSubject().getId() + " not found");
                }
            }

            if (fromClient.getClassRoom() != null) {
                if (fromClient.getClassRoom().getId() != null) {
                    if (loadFromDb.getClassRoom() == null || !Objects.equals(loadFromDb.getClassRoom().getId(), fromClient.getClassRoom().getId())) {
                        Optional<ClassroomEntity> classRoom = classroomRepository.findById(fromClient.getClassRoom().getId());
                        if (classRoom.isPresent()) {
                            loadFromDb.setClassRoom(classRoom.get());
                        } else {
                            throw new EntityNotFoundException("Classroom with id " + fromClient.getClassRoom().getId() + " not found");
                        }
                    }
                } else {
                    throw new EntityNotFoundException("Classroom with id " + fromClient.getClassRoom().getId() + " not found");
                }
            }

            repository.save(loadFromDb);
        }
    }

    @Override
    protected TimetableOfClassesEntity createEmptyEntity() {
        return new TimetableOfClassesEntity();
    }
}
