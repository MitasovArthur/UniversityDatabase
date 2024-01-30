package ua.edu.udhtu.model.dto;

import java.util.List;

public class SubjectDto extends BaseDto<Long> {
    private String nameSubject;
    private double hoursSubject;
    private List<ActivityDto> activity;

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public double getHoursSubject() {
        return hoursSubject;
    }

    public void setHoursSubject(double hoursSubject) {
        this.hoursSubject = hoursSubject;
    }

    public List<ActivityDto> getActivity() {
        return activity;
    }

    public void setActivity(List<ActivityDto> activity) {
        this.activity = activity;
    }
}
