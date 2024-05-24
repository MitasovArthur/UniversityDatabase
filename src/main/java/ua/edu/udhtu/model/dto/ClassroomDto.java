package ua.edu.udhtu.model.dto;

import ua.edu.udhtu.model.enumerated.EClassRoomType;

import java.util.List;

public class ClassroomDto extends BaseDto<Long> {
    private String code;
    private EClassRoomType type;
    private List<TimetableOfClassesDto> timetableOfClasses;

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

    public List<TimetableOfClassesDto> getTimetableOfClasses() {
        return timetableOfClasses;
    }

    public void setTimetableOfClasses(List<TimetableOfClassesDto> timetableOfClasses) {
        this.timetableOfClasses = timetableOfClasses;
    }
}
