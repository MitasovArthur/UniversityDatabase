package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.ClassroomEntity;
import ua.edu.udhtu.repository.ClassroomRepository;

@Service
public class ClassroomService extends BasedService<ClassroomEntity, Long> {
    public ClassroomService(ClassroomRepository repository) {
        super(ClassroomEntity.class, repository);
    }
//    @Autowired
    @Override
    protected void fillEntity(ClassroomEntity loadFromDb, ClassroomEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setId(fromClient.getId());
            loadFromDb.setCode(fromClient.getCode());
            loadFromDb.setType(fromClient.getType());
        }
    }
}
