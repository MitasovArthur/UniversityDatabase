package ua.edu.udhtu.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class SubjectEntity extends BasedEntity<Long> {
    @Column(name = "name_subject", length = 50)
    private String nameSubject;
    @Column(name = "hour_subject")
    private double hourSubject;
    @ManyToMany(targetEntity = TeacherEntity.class, mappedBy = "subjects", fetch = FetchType.LAZY)
    private Set<TeacherEntity> teachers;
    @OneToMany(targetEntity = TimetableOfClassesEntity.class, mappedBy = "subject", fetch = FetchType.LAZY)
    private List<TimetableOfClassesEntity> timetableOfClasses;
    @ManyToOne(targetEntity = StudyGroupEntity.class)
    @JoinColumn(name = "study_group_id")
    private StudyGroupEntity studyGroup;
    @OneToMany(targetEntity = ActivityEntity.class, mappedBy = "subject", cascade = CascadeType.REMOVE)
    private List<ActivityEntity> activity;
    @OneToMany(targetEntity = GradeBookEntity.class, mappedBy = "subject")
    private List<GradeBookEntity> gradeBooks;

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public double getHourSubject() {
        return hourSubject;
    }

    public void setHourSubject(double hourSubject) {
        this.hourSubject = hourSubject;
    }

    public Set<TeacherEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherEntity> teachers) {
        this.teachers = teachers;
    }

    public List<TimetableOfClassesEntity> getTimetableOfClasses() {
        return timetableOfClasses;
    }

    public void setTimetableOfClasses(List<TimetableOfClassesEntity> timetableOfClasses) {
        this.timetableOfClasses = timetableOfClasses;
    }

    public StudyGroupEntity getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroupEntity studyGroup) {
        this.studyGroup = studyGroup;
    }

    public List<ActivityEntity> getActivity() {
        return activity;
    }

    public void setActivity(List<ActivityEntity> activity) {
        this.activity = activity;
    }

    public List<GradeBookEntity> getGradeBooks() {
        return gradeBooks;
    }

    public void setGradeBooks(List<GradeBookEntity> gradeBooks) {
        this.gradeBooks = gradeBooks;
    }
}
