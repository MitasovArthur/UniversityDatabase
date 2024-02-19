package ua.edu.udhtu.service.impl;

import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.TimetableOfClassesEntity;
import ua.edu.udhtu.repository.TimeTableOfClassRepository;

@Service
public class TimeTableOfClassService extends BasedService<TimetableOfClassesEntity, Long> {
    public TimeTableOfClassService(TimeTableOfClassRepository repository) {
        super(TimetableOfClassesEntity.class, repository);
    }
}
