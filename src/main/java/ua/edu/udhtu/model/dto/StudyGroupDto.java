package ua.edu.udhtu.model.dto;

import ua.edu.udhtu.model.entity.TeacherEntity;

import java.util.List;

public class StudyGroupDto extends BaseDto<Long> {
    private String code;
    private TeacherEntity curator;
    private List<StudentDto> students;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TeacherEntity getCurator() {
        return curator;
    }

    public void setCurator(TeacherEntity curator) {
        this.curator = curator;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }
}
