package ua.edu.udhtu.model.dto;

import java.util.List;

public class SubjectDto extends BaseDto<Long> {
    private String nameSubject;
    private double hourSubject;
    private List<ActivityDto> activity;

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public double getHourSubject() {
        return hourSubject;
    }

    public void setHourSubject(double hoursSubject) {
        this.hourSubject = hoursSubject;
    }

    public List<ActivityDto> getActivity() {
        return activity;
    }

    public void setActivity(List<ActivityDto> activity) {
        this.activity = activity;
    }
}
