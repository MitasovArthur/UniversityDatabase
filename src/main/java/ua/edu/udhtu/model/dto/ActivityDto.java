package ua.edu.udhtu.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ActivityDto extends BaseDto<Long> {
    private SubjectDto subject;
    private StudentDto student;
    private String nameActivity;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date deadLine;
    private int grade;
    private GradeBookDto gradeBook;

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public GradeBookDto getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(GradeBookDto gradeBook) {
        this.gradeBook = gradeBook;
    }

    public SubjectDto getSubject() {
        return subject;
    }

    public void setSubject(SubjectDto subject) {
        this.subject = subject;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }
}
