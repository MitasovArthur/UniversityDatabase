package ua.edu.udhtu.model.dto;

import ua.edu.udhtu.model.enumerated.EClassRoomType;

public class ClassroomDto extends BaseDto<Long> {
    private String code;
    private EClassRoomType type;

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
}
