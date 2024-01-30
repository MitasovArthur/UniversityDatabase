package ua.edu.udhtu.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TimetableOfClassesDto extends BaseDto<Long> {
    private TeacherDto teacher;
    private StudyGroupDto studyGroup;
    private SubjectDto subject;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date startLesson;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")

    private Date endLesson;

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

    public SubjectDto getSubject() {
        return subject;
    }

    public void setSubject(SubjectDto subject) {
        this.subject = subject;
    }

    public Date getStartLesson() {
        return startLesson;
    }

    public void setStartLesson(Date startLesson) {
        this.startLesson = startLesson;
    }

    public Date getEndLesson() {
        return endLesson;
    }

    public void setEndLesson(Date endLesson) {
        this.endLesson = endLesson;
    }
}
