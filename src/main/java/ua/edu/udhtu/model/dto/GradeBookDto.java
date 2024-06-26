package ua.edu.udhtu.model.dto;

import java.util.List;

public class GradeBookDto extends BaseDto<Long> {
    private SubjectDto subject;
    private TeacherDto teacher;
    private StudyGroupDto studyGroup;
    private List<ActivityDto> activity;
    private int grade;
    private double semesterGrade;
    private double yearlyGrade;

    public SubjectDto getSubject() {
        return subject;
    }

    public void setSubject(SubjectDto subject) {
        this.subject = subject;
    }

    public TeacherDto getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDto teacher) {
        this.teacher = teacher;
    }

    public StudyGroupDto getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroupDto studyGroup) {
        this.studyGroup = studyGroup;
    }

    public List<ActivityDto> getActivity() {
        return activity;
    }

    public void setActivity(List<ActivityDto> activity) {
        this.activity = activity;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getSemesterGrade() {
        return semesterGrade;
    }

    public void setSemesterGrade(double semesterGrade) {
        this.semesterGrade = semesterGrade;
    }

    public double getYearlyGrade() {
        return yearlyGrade;
    }

    public void setYearlyGrade(double yearlyGrade) {
        this.yearlyGrade = yearlyGrade;
    }
}
