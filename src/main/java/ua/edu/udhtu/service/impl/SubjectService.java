package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.SubjectEntity;
import ua.edu.udhtu.repository.SubjectRepository;

@Service
public class SubjectService extends BasedService<SubjectEntity, Long> {
    @Autowired
    public SubjectService(SubjectRepository repository) {
        super(SubjectEntity.class, repository);
    }

    @Override
    protected void fillEntity(SubjectEntity loadFromDb, SubjectEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setId(fromClient.getId());
            loadFromDb.setNameSubject(fromClient.getNameSubject());
            loadFromDb.setHourSubject(fromClient.getHourSubject());
//            loadFromDb.setActivity(fromClient.getActivity());
        }
    }
}
