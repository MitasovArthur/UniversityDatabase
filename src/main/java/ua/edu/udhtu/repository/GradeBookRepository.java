package ua.edu.udhtu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.udhtu.model.entity.GradeBookEntity;

@Repository
public interface GradeBookRepository extends JpaRepository<GradeBookEntity, Long> {
}
