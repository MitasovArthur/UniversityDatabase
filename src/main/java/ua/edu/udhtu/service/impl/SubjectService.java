package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.StudyGroupEntity;
import ua.edu.udhtu.model.entity.SubjectEntity;
import ua.edu.udhtu.repository.StudyGroupRepository;
import ua.edu.udhtu.repository.SubjectRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubjectService extends BasedService<SubjectEntity, Long> {
    private final StudyGroupRepository studyGroupRepository;

    @Autowired
    public SubjectService(SubjectRepository repository, StudyGroupRepository studyGroupRepository) {
        super(SubjectEntity.class, repository);
        this.studyGroupRepository = studyGroupRepository;
    }

    @Override
    protected void fillEntity(SubjectEntity loadFromDb, SubjectEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setId(fromClient.getId());
            loadFromDb.setNameSubject(fromClient.getNameSubject());
            loadFromDb.setHourSubject(fromClient.getHourSubject());
            if (fromClient.getStudyGroup() != null) {
                if (fromClient.getStudyGroup().getId() != null) {
                    if (loadFromDb.getStudyGroup() == null || !Objects.equals(loadFromDb.getStudyGroup().getId(), fromClient.getStudyGroup().getId())) {
                        Optional<StudyGroupEntity> group = studyGroupRepository.findById(fromClient.getStudyGroup().getId());
                        if (group.isPresent()) {
                            loadFromDb.setStudyGroup(group.get());
                        } else {
                            throw new IllegalStateException("Teacher with id " + fromClient.getStudyGroup().getId() + " is already assigned as a curator to another group.");
                        }
                    }
                } else {
                    throw new EntityNotFoundException("Group with id " + fromClient.getStudyGroup().getId() + " not found");

                }
            }
            repository.save(loadFromDb);
//            loadFromDb.setActivity(fromClient.getActivity());
        }
    }

    @Override
    protected SubjectEntity createEmptyEntity() {
        return new SubjectEntity();
    }
}
