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
}
