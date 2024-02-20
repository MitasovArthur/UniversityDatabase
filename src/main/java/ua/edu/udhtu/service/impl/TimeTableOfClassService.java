package ua.edu.udhtu.service.impl;

import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.TimetableOfClassesEntity;
import ua.edu.udhtu.repository.TimeTableOfClassRepository;

@Service
public class TimeTableOfClassService extends BasedService<TimetableOfClassesEntity, Long> {
    public TimeTableOfClassService(TimeTableOfClassRepository repository) {
        super(TimetableOfClassesEntity.class, repository);
    }

    @Override
    protected void fillEntity(TimetableOfClassesEntity loadFromDb, TimetableOfClassesEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setId(fromClient.getId());
            loadFromDb.setTeacher(fromClient.getTeacher());
            loadFromDb.setStudyGroup(fromClient.getStudyGroup());
            loadFromDb.setSubject(fromClient.getSubject());
            loadFromDb.setStartLesson(fromClient.getStartLesson());
            loadFromDb.setEndLesson(fromClient.getEndLesson());
        }
    }
}
