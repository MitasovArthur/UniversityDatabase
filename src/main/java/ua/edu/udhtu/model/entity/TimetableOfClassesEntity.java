package ua.edu.udhtu.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "timetable_of_classes")
public class TimetableOfClassesEntity extends BasedEntity<Long> {
    @ManyToOne(targetEntity = TeacherEntity.class)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;
    @ManyToOne(targetEntity = StudyGroupEntity.class)
    @JoinColumn(name = "study_group")
    private StudyGroupEntity studyGroup;
    @ManyToOne(targetEntity = SubjectEntity.class)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;
    @ManyToOne(targetEntity = ClassroomEntity.class)
    @JoinColumn(name = "class_room_id")
    private ClassroomEntity classRoom;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_lesson")
    private Date startLesson;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_lesson")
    private Date endLesson;

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public StudyGroupEntity getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroupEntity studyGroup) {
        this.studyGroup = studyGroup;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public ClassroomEntity getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassroomEntity classRoom) {
        this.classRoom = classRoom;
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
