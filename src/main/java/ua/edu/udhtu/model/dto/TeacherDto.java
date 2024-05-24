package ua.edu.udhtu.model.dto;

import ua.edu.udhtu.model.enumerated.EAcademicDegree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeacherDto extends BaseDto<Long> {
    private PersonDto person;
    private EAcademicDegree academicDegree;
    private Set<SubjectDto> subjects = new HashSet<>();
    private StudyGroupDto studyGroup;
    private List<TimetableOfClassesDto> timetableOfClasses;
    private List<GradeBookDto> gradeBook;

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

    public Set<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<SubjectDto> subjects) {
        this.subjects = subjects;
    }

    public StudyGroupDto getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroupDto studyGroup) {
        this.studyGroup = studyGroup;
    }

    public List<TimetableOfClassesDto> getTimetableOfClasses() {
        return timetableOfClasses;
    }

    public void setTimetableOfClasses(List<TimetableOfClassesDto> timetableOfClasses) {
        this.timetableOfClasses = timetableOfClasses;
    }

    public List<GradeBookDto> getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(List<GradeBookDto> gradeBook) {
        this.gradeBook = gradeBook;
    }
}
