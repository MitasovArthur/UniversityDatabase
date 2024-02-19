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
}
