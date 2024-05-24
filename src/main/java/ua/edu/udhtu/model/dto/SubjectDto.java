package ua.edu.udhtu.model.dto;

import java.util.List;
import java.util.Set;

public class SubjectDto extends BaseDto<Long> {
    private String nameSubject;
    private double hourSubject;
    private Set<TeacherDto> teacher;
    private List<TimetableOfClassesDto> timetableOfClasses;
    private StudyGroupDto studyGroup;
    private List<ActivityDto> activity;
    private List<GradeBookDto> gradeBook;

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public double getHourSubject() {
        return hourSubject;
    }

    public void setHourSubject(double hourSubject) {
        this.hourSubject = hourSubject;
    }

    public Set<TeacherDto> getTeacher() {
        return teacher;
    }

    public void setTeacher(Set<TeacherDto> teacher) {
        this.teacher = teacher;
    }

    public List<TimetableOfClassesDto> getTimetableOfClasses() {
        return timetableOfClasses;
    }

    public void setTimetableOfClasses(List<TimetableOfClassesDto> timetableOfClasses) {
        this.timetableOfClasses = timetableOfClasses;
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

    public List<GradeBookDto> getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(List<GradeBookDto> gradeBook) {
        this.gradeBook = gradeBook;
    }
}
