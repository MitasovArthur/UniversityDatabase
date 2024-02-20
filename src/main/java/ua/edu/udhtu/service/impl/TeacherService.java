package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.TeacherEntity;
import ua.edu.udhtu.repository.TeacherRepository;

@Service
public class TeacherService extends BasedService<TeacherEntity, Long> {
    @Autowired
    public TeacherService(TeacherRepository repository) {
        super(TeacherEntity.class, repository);
    }

    @Override
    protected void fillEntity(TeacherEntity loadFromDb, TeacherEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setId(fromClient.getId());
            loadFromDb.setPerson(fromClient.getPerson());
            loadFromDb.setAcademicDegree(fromClient.getAcademicDegree());
            loadFromDb.setSubjects(fromClient.getSubjects());
        }
    }
}
