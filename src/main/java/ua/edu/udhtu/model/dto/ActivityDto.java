package ua.edu.udhtu.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.security.auth.Subject;
import java.util.Date;

public class ActivityDto extends BaseDto<Long> {
    private SubjectDto subjectDto;
    private String nameActivity;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM")
    private Date deadLine;
    private StudentDto studentDto;
    private int grade;
    private GradeBookDto gradeBookDto;

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

    public SubjectDto getSubjectDto() {
        return subjectDto;
    }

    public void setSubjectDto(SubjectDto subjectDto) {
        this.subjectDto = subjectDto;
    }

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    public GradeBookDto getGradeBookDto() {
        return gradeBookDto;
    }

    public void setGradeBookDto(GradeBookDto gradeBookDto) {
        this.gradeBookDto = gradeBookDto;
    }
}
