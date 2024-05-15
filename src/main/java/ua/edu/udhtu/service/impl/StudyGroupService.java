package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.StudyGroupEntity;
import ua.edu.udhtu.model.entity.TeacherEntity;
import ua.edu.udhtu.repository.StudyGroupRepository;
import ua.edu.udhtu.repository.TeacherRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class StudyGroupService extends BasedService<StudyGroupEntity, Long> {
    private final TeacherRepository teacherRepository;

    @Autowired
    public StudyGroupService(StudyGroupRepository repository, TeacherRepository teacherRepository) {
        super(StudyGroupEntity.class, repository);
        this.teacherRepository = teacherRepository;
    }

    @Override
    protected void fillEntity(StudyGroupEntity loadFromDb, StudyGroupEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setCode(fromClient.getCode());
            if (fromClient.getCurator() != null) {
                if (fromClient.getCurator().getId() != null) {
                    Optional<TeacherEntity> existingCurator = teacherRepository.findById(fromClient.getCurator().getId());
                    if (existingCurator.isPresent()) {
                        loadFromDb.setCurator(existingCurator.get());
                    } else {
                        throw new EntityNotFoundException("Curator with id " + fromClient.getCurator().getId() + " not found");
                    }
                } else {
                    TeacherEntity newCurator = new TeacherEntity();
                    newCurator.setPerson(fromClient.getCurator().getPerson());  // Убедитесь, что person также сохранён или управляется
                    newCurator.setAcademicDegree(fromClient.getCurator().getAcademicDegree());
                    teacherRepository.saveAndFlush(newCurator);  // Сохраняем и немедленно синхронизируем состояние с базой
                    loadFromDb.setCurator(newCurator);
                }
            }
        }
    }


}
