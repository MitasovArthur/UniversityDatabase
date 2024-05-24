package ua.edu.udhtu.controler.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.udhtu.Factory.impl.TimeTableOfClassFactory;
import ua.edu.udhtu.model.dto.TimetableOfClassesDto;
import ua.edu.udhtu.model.entity.TimetableOfClassesEntity;
import ua.edu.udhtu.service.impl.TimeTableOfClassService;

@RestController
@RequestMapping("timeTableOfClass")
public class TimeTableOfClassController extends BasedController<TimetableOfClassesEntity, TimetableOfClassesDto, Long, TimeTableOfClassFactory> {

    public TimeTableOfClassController(TimeTableOfClassService service, TimeTableOfClassFactory factory) {
        super(TimetableOfClassesEntity.class, TimetableOfClassesDto.class, service, factory);
    }
}
