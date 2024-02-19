package ua.edu.udhtu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.udhtu.model.entity.TeacherEntity;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
