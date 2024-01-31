package ua.edu.udhtu.model.entity;

import ua.edu.udhtu.model.enumerated.EAcademicDegree;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class TeacherEntity extends BasedEntity<Long> {
    @OneToOne(targetEntity = PersonEntity.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "person_id")
    private PersonEntity person;
    @Enumerated(EnumType.STRING)
    @Column(name = "academic_degree", length = 20)
    private EAcademicDegree academicDegree;
    @ManyToMany(targetEntity = SubjectEntity.class)
    @JoinTable(name = "teaches_the_subject", joinColumns = @JoinColumn(name = "teacher_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<SubjectEntity> subjects;
    @OneToOne(targetEntity = StudyGroupEntity.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private StudyGroupEntity studyGroup;
    @OneToMany(targetEntity = TimetableOfClassesEntity.class, mappedBy = "studyGroup", fetch = FetchType.LAZY)
    private List<TimetableOfClassesEntity> timetableOfClasses;
    @OneToMany(targetEntity = GradeBookEntity.class, mappedBy = "teacher")
    private List<GradeBookEntity> gradeBooks;

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public EAcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(EAcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Set<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<SubjectEntity> subjects) {
        this.subjects = subjects;
    }

    public StudyGroupEntity getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroupEntity studyGroup) {
        this.studyGroup = studyGroup;
    }

    public List<TimetableOfClassesEntity> getTimetableOfClasses() {
        return timetableOfClasses;
    }

    public void setTimetableOfClasses(List<TimetableOfClassesEntity> timetableOfClasses) {
        this.timetableOfClasses = timetableOfClasses;
    }

    public List<GradeBookEntity> getGradeBooks() {
        return gradeBooks;
    }

    public void setGradeBooks(List<GradeBookEntity> gradeBooks) {
        this.gradeBooks = gradeBooks;
    }
}
