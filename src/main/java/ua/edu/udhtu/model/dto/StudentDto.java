package ua.edu.udhtu.model.dto;

import ua.edu.udhtu.model.enumerated.EEducationType;

public class StudentDto extends BaseDto<Long> {
    private PersonDto person;
    private EEducationType educationType;
    private String address;
    private String email;
    private StudyGroupDto studyGroupDto;

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

    public StudyGroupDto getStudyGroupDto() {
        return studyGroupDto;
    }

    public void setStudyGroupDto(StudyGroupDto studyGroupDto) {
        this.studyGroupDto = studyGroupDto;
    }
}
