package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.StudentEntity;
import ua.edu.udhtu.repository.StudentRepository;

@Service
public class StudentService extends BasedService<StudentEntity, Long> {
    @Autowired
    public StudentService(StudentRepository repository) {
        super(StudentEntity.class, repository);
    }
}
