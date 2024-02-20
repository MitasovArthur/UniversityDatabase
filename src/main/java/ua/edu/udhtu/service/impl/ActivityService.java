package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.ActivityEntity;
import ua.edu.udhtu.repository.ActivityRepository;

@Service
public class ActivityService extends BasedService<ActivityEntity, Long> {
    @Autowired
    public ActivityService(ActivityRepository repository) {
        super(ActivityEntity.class, repository);
    }

    @Override
    protected void fillEntity(ActivityEntity loadFromDb, ActivityEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setId(fromClient.getId());
            loadFromDb.setNameActivity(fromClient.getNameActivity());
            loadFromDb.setDescription(fromClient.getDescription());
            loadFromDb.setDeadLine(fromClient.getDeadLine());
            loadFromDb.setGrade(fromClient.getGrade());
        }
    }
}
