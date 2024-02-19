package ua.edu.udhtu.model.entity;

import ua.edu.udhtu.model.enumerated.EClassRoomType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class_rooms")
public class ClassroomEntity extends BasedEntity<Long> {
    @Column(name = "code", length = 20)
    private String code;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 20)
    private EClassRoomType type;
    @OneToMany(targetEntity = TimetableOfClassesEntity.class, mappedBy = "classRoom", fetch = FetchType.LAZY)
    private List<TimetableOfClassesEntity> timetableOfClasses;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EClassRoomType getType() {
        return type;
    }

    public void setType(EClassRoomType type) {
        this.type = type;
    }

    public List<TimetableOfClassesEntity> getTimetableOfClasses() {
        return timetableOfClasses;
    }

    public void setTimetableOfClasses(List<TimetableOfClassesEntity> timetableOfClasses) {
        this.timetableOfClasses = timetableOfClasses;
    }
}
