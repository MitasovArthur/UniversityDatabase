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

    @Override
    protected void fillEntity(GradeBookEntity loadFromDb, GradeBookEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setId(fromClient.getId());
            loadFromDb.setSubject(fromClient.getSubject());
            loadFromDb.setActivity(fromClient.getActivity());
            loadFromDb.setGrade(fromClient.getGrade());
            loadFromDb.setSemesterGrade(fromClient.getSemesterGrade());
            loadFromDb.setYearlyGrade(fromClient.getYearlyGrade());
        }
    }
}
