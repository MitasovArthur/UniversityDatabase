package ua.edu.udhtu.model.dto;

import ua.edu.udhtu.model.entity.SubjectEntity;
import ua.edu.udhtu.model.entity.TeacherEntity;
import ua.edu.udhtu.model.entity.TimetableOfClassesEntity;

import java.util.ArrayList;
import java.util.List;

public class StudyGroupDto extends BaseDto<Long> {
    private String code;
    private TeacherDto curator;
    private GradeBookDto gradeBook;
    private List<SubjectDto> subjects = new ArrayList<>();
    private List<StudentDto> students;
    private List<TimetableOfClassesDto> timetableOfClasses;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TeacherDto getCurator() {
        return curator;
    }

    public void setCurator(TeacherDto curator) {
        this.curator = curator;
    }

    public GradeBookDto getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(GradeBookDto gradeBook) {
        this.gradeBook = gradeBook;
    }

    public List<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDto> subjects) {
        this.subjects = subjects;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public List<TimetableOfClassesDto> getTimetableOfClasses() {
        return timetableOfClasses;
    }

    public void setTimetableOfClasses(List<TimetableOfClassesDto> timetableOfClasses) {
        this.timetableOfClasses = timetableOfClasses;
    }
}
