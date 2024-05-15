package ua.edu.udhtu.Factory.impl;

import org.springframework.stereotype.Component;
import ua.edu.udhtu.model.dto.GradeBookDto;
import ua.edu.udhtu.model.dto.SubjectDto;
import ua.edu.udhtu.model.entity.GradeBookEntity;
import ua.edu.udhtu.model.entity.SubjectEntity;

import java.util.ArrayList;

@Component
public class GradeBookFactory extends AbstractTableFactory<GradeBookEntity, GradeBookDto, Long> {
    private AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory;

    public void setSubjectFactory(AbstractTableFactory<SubjectEntity, SubjectDto, Long> subjectFactory) {
        this.subjectFactory = subjectFactory;
    }

    @Override
    protected GradeBookDto buildDto(GradeBookEntity entity, boolean all) {
        GradeBookDto dto = new GradeBookDto();
        dto.setId(entity.getId());
//        dto.setSubject(subjectFactory.createDto(entity.getSubject()));
//        dto.setActivity(new ArrayList<>(entity.getActivity().size()));
        dto.setGrade(entity.getGrade());
        dto.setSemesterGrade(entity.getSemesterGrade());
        dto.setYearlyGrade(entity.getYearlyGrade());
        return dto;
    }

    @Override
    protected GradeBookEntity createEmptyEntity() {
        return new GradeBookEntity();
    }

    @Override
    protected GradeBookDto createEmptyDto() {
        return new GradeBookDto();
    }

    @Override
    protected void fillEntity(GradeBookDto dto, GradeBookEntity entity) {
        fillEntityWithOnlyId(dto, entity);
        entity.setId(dto.getId());
//        entity.setSubject(subjectFactory.createEntityWithOnlyId(dto.getSubject()));
//        entity.setActivity(new ArrayList<>(entity.getActivity().size()));
        entity.setGrade(dto.getGrade());
        entity.setSemesterGrade(dto.getSemesterGrade());
        entity.setYearlyGrade(dto.getYearlyGrade());
    }

    @Override
    protected void fillEntityWithOnlyId(GradeBookDto dto, GradeBookEntity entity) {
        entity.setId(dto.getId());
    }
}
