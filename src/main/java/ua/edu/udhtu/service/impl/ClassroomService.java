package ua.edu.udhtu.service.impl;

import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.ClassroomEntity;
import ua.edu.udhtu.repository.ClassroomRepository;

@Service
public class ClassroomService extends BasedService<ClassroomEntity, Long> {
    public ClassroomService(ClassroomRepository repository) {
        super(ClassroomEntity.class, repository);
    }
}
