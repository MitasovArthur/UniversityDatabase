package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.GradeBookEntity;
import ua.edu.udhtu.repository.GradeBookRepository;

@Service
public class GradeBookService extends BasedService<GradeBookEntity, Long> {
    @Autowired
    public GradeBookService(GradeBookRepository repository) {
        super(GradeBookEntity.class, repository);
    }
}
