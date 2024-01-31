package ua.edu.udhtu.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grade_book")
public class GradeBookEntity extends BasedEntity<Long> {
    @ManyToOne(targetEntity = SubjectEntity.class)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;
    @ManyToOne(targetEntity = TeacherEntity.class)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;
    @OneToOne(targetEntity = StudyGroupEntity.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private StudyGroupEntity group;
    @OneToMany(targetEntity = ActivityEntity.class, mappedBy = "gradeBook", cascade = CascadeType.REMOVE)
    private List<ActivityEntity> activity;
    @Column(name = "grade")
    private int grade;
    @Column(name = "semester_grade")
    private double semesterGrade;
    @Column(name = "yearly_grade")
    private double yearlyGrade;

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public StudyGroupEntity getGroup() {
        return group;
    }

    public void setGroup(StudyGroupEntity group) {
        this.group = group;
    }

    public List<ActivityEntity> getActivity() {
        return activity;
    }

    public void setActivity(List<ActivityEntity> activity) {
        this.activity = activity;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getSemesterGrade() {
        return semesterGrade;
    }

    public void setSemesterGrade(double semesterGrade) {
        this.semesterGrade = semesterGrade;
    }

    public double getYearlyGrade() {
        return yearlyGrade;
    }

    public void setYearlyGrade(double yearlyGrade) {
        this.yearlyGrade = yearlyGrade;
    }
}
