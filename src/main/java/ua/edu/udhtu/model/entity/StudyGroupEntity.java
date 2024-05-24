package ua.edu.udhtu.model.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_groups")
public class StudyGroupEntity extends BasedEntity<Long> {
    @Column(name = "code", length = 25)
    private String code;
    @OneToOne(targetEntity = TeacherEntity.class )
    private TeacherEntity curator;
    @OneToOne(targetEntity = GradeBookEntity.class, mappedBy = "studyGroup")
    private GradeBookEntity gradeBook;
    @OneToMany(targetEntity = SubjectEntity.class, mappedBy = "studyGroup", fetch = FetchType.LAZY)
    private List<SubjectEntity> subjects = new ArrayList<>();
    @OneToMany(targetEntity = StudentEntity.class, mappedBy = "studyGroup", cascade = CascadeType.REMOVE)
    private List<StudentEntity> students = new ArrayList<>();
    @OneToMany(targetEntity = TimetableOfClassesEntity.class, mappedBy = "studyGroup", fetch = FetchType.LAZY)
    private List<TimetableOfClassesEntity> timetableOfClasses = new ArrayList<>();

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

    public GradeBookEntity getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(GradeBookEntity gradeBook) {
        this.gradeBook = gradeBook;
    }

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
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
