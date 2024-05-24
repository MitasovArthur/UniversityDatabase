package ua.edu.udhtu.model.entity;

import ua.edu.udhtu.model.enumerated.EEducationType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class StudentEntity extends BasedEntity<Long> {
    @OneToOne(targetEntity = PersonEntity.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "person_id")
    private PersonEntity person;
    @Column(name = "address", length = 50)
    private String address;
    @Column(name = "email", length = 40)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "education_type", length = 10)
    private EEducationType educationType;
    @ManyToOne(targetEntity = StudyGroupEntity.class)
    @JoinColumn(name = "study_group_id")
    private StudyGroupEntity studyGroup;
    @OneToMany(targetEntity = ActivityEntity.class, mappedBy = "student", cascade = CascadeType.REMOVE)
    private List<ActivityEntity> activity = new ArrayList<>();

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public EEducationType getEducationType() {
        return educationType;
    }

    public void setEducationType(EEducationType educationType) {
        this.educationType = educationType;
    }

    public StudyGroupEntity getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroupEntity studyGroup) {
        this.studyGroup = studyGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ActivityEntity> getActivity() {
        return activity;
    }

    public void setActivity(List<ActivityEntity> activity) {
        this.activity = activity;
    }

}
