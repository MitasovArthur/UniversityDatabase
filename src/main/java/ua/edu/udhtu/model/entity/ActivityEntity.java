package ua.edu.udhtu.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activity")
public class ActivityEntity extends BasedEntity<Long> {
    @ManyToOne(targetEntity = SubjectEntity.class)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;
    @Column(name = "name_activity", length = 50)
    private String nameActivity;
    @Column(name = "description")
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dead_line")
    private Date deadLine;
    @ManyToOne(targetEntity = StudentEntity.class)
    @JoinColumn(name = "student_id")
    private StudentEntity student;
    @Column(name = "grade")
    private int grade;
    @ManyToOne(targetEntity = GradeBookEntity.class)
    @JoinColumn(name = "grade_book_id")
    private GradeBookEntity gradeBook;

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public GradeBookEntity getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(GradeBookEntity gradeBook) {
        this.gradeBook = gradeBook;
    }
}
