package ua.edu.udhtu.model.dto;

import ua.edu.udhtu.model.enumerated.EEducationType;

import java.util.ArrayList;
import java.util.List;

public class StudentDto extends BaseDto<Long> {
    private PersonDto person;
    private EEducationType educationType;
    private String address;
    private String email;
    private StudyGroupDto studyGroup;
    private List<ActivityDto> activity = new ArrayList<>();
    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public EEducationType getEducationType() {
        return educationType;
    }

    public void setEducationType(EEducationType educationType) {
        this.educationType = educationType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StudyGroupDto getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroupDto studyGroupDto) {
        this.studyGroup = studyGroupDto;
    }

    public List<ActivityDto> getActivity() {
        return activity;
    }

    public void setActivity(List<ActivityDto> activity) {
        this.activity = activity;
    }
}
