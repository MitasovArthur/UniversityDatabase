package org.example.model.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "study_groups")
public class StudyGroupEntity extends BasedEntity<Long> {
    @Column(name = "code", length = 25)
    private int code;
    @OneToOne(targetEntity = TeacherEntity.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @Column(name = "curator")
    private TeacherEntity curator;
    @OneToMany(targetEntity = SubjectEntity.class, mappedBy = "studyGroup", cascade = CascadeType.REMOVE)
    private List<StudentEntity> students;
    @OneToMany(targetEntity = TimetableOfClassesEntity.class,mappedBy = "studyGroup",fetch = FetchType.LAZY)
    private List<TimetableOfClassesEntity> timetableOfClasses;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
