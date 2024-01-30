package ua.edu.udhtu.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ActivityDto extends BaseDto<Long> {
    private String nameActivity;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM")//~LocalDataTime dd.MM-HH
    private Date deadLine;
    private int grade;

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
}
