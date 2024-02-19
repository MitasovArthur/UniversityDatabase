package ua.edu.udhtu.controler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.udhtu.Factory.impl.ActivityFactory;
import ua.edu.udhtu.model.dto.ActivityDto;
import ua.edu.udhtu.model.entity.ActivityEntity;
import ua.edu.udhtu.service.impl.ActivityService;

@RestController
@RequestMapping("activity")
public class ActivityController extends BasedController<ActivityEntity, ActivityDto, Long, ActivityFactory> {
    @Autowired
    public ActivityController(ActivityService service, ActivityFactory factory) {
        super(ActivityEntity.class, ActivityDto.class, service, factory);
    }
}
