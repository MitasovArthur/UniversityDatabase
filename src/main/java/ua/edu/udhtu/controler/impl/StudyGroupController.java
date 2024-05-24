package ua.edu.udhtu.controler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.udhtu.Factory.impl.StudyGroupFactory;
import ua.edu.udhtu.model.dto.StudyGroupDto;
import ua.edu.udhtu.model.entity.StudyGroupEntity;
import ua.edu.udhtu.service.impl.StudyGroupService;

@RestController
@RequestMapping("studyGroup")
public class StudyGroupController extends BasedController<StudyGroupEntity, StudyGroupDto, Long, StudyGroupFactory> {
    @Autowired
    public StudyGroupController(StudyGroupService service, StudyGroupFactory factory) {
        super(StudyGroupEntity.class, StudyGroupDto.class, service, factory);
    }


}
