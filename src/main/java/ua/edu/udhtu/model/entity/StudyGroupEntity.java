package ua.edu.udhtu.model.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "study_groups")
public class StudyGroupEntity extends BasedEntity<Long> {
    @Column(name = "code", length = 25)
    private String code;
    @OneToOne(mappedBy = "studyGroup")
    private TeacherEntity curator;
    @OneToMany(targetEntity = StudentEntity.class, mappedBy = "studyGroup", cascade = CascadeType.REMOVE)
    private List<StudentEntity> students;
    @OneToMany(targetEntity = TimetableOfClassesEntity.class, mappedBy = "studyGroup", fetch = FetchType.LAZY)
    private List<TimetableOfClassesEntity> timetableOfClasses;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TeacherEntity getCurator() {
        return curator;
    }

    public void setCurator(TeacherEntity curator) {
        this.curator = curator;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    public List<TimetableOfClassesEntity> getTimetableOfClasses() {
        return timetableOfClasses;
    }

    public void setTimetableOfClasses(List<TimetableOfClassesEntity> timetableOfClasses) {
        this.timetableOfClasses = timetableOfClasses;
    }
}
