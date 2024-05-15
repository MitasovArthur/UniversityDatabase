package ua.edu.udhtu.model.dto;

import ua.edu.udhtu.model.enumerated.EAcademicDegree;

import java.util.List;

public class TeacherDto extends BaseDto<Long> {
    private PersonDto person;
    private EAcademicDegree academicDegree;
    private List<SubjectDto> subjects;
    private StudyGroupDto studyGroup;
    /**Nujno?*/
    private TimetableOfClassesDto timetableOfClasses;
    private GradeBookDto gradeBook;

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

    public StudyGroupDto getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroupDto studyGroup) {
        this.studyGroup = studyGroup;
    }

    public TimetableOfClassesDto getTimetableOfClasses() {
        return timetableOfClasses;
    }

    public void setTimetableOfClasses(TimetableOfClassesDto timetableOfClasses) {
        this.timetableOfClasses = timetableOfClasses;
    }

    public GradeBookDto getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(GradeBookDto gradeBook) {
        this.gradeBook = gradeBook;
    }
}
