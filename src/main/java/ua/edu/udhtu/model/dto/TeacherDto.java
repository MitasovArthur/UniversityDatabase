package ua.edu.udhtu.model.dto;

import ua.edu.udhtu.model.enumerated.EAcademicDegree;

import java.util.List;

public class TeacherDto extends BaseDto<Long> {
    private PersonDto person;
    private EAcademicDegree academicDegree;
    private List<SubjectDto> subjects;

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public EAcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(EAcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public List<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDto> subjects) {
        this.subjects = subjects;
    }
}
