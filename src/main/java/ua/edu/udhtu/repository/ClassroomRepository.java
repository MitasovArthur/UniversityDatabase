package ua.edu.udhtu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.udhtu.model.entity.ClassroomEntity;

@Repository
public interface ClassroomRepository extends JpaRepository<ClassroomEntity, Long> {
}
