package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.StudyGroupEntity;
import ua.edu.udhtu.repository.StudyGroupRepository;

@Service
public class StudyGroupService extends BasedService<StudyGroupEntity, Long> {
    @Autowired
    public StudyGroupService(StudyGroupRepository repository) {
        super(StudyGroupEntity.class, repository);
    }
}
