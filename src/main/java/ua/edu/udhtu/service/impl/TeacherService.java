package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.PersonEntity;
import ua.edu.udhtu.model.entity.StudyGroupEntity;
import ua.edu.udhtu.model.entity.TeacherEntity;
import ua.edu.udhtu.repository.PersonRepository;
import ua.edu.udhtu.repository.StudyGroupRepository;
import ua.edu.udhtu.repository.TeacherRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherService extends BasedService<TeacherEntity, Long> {
    private final PersonRepository personRepository;
    private final StudyGroupRepository studyGroupRepository;

    @Autowired
    public TeacherService(TeacherRepository repository, PersonRepository personRepository, StudyGroupRepository studyGroupRepository) {
        super(TeacherEntity.class, repository);
        this.personRepository = personRepository;
        this.studyGroupRepository = studyGroupRepository;
    }

    @Override
    protected void fillEntity(TeacherEntity loadFromDb, TeacherEntity fromClient) {
        if (loadFromDb != null && fromClient != null) {
            loadFromDb.setId(fromClient.getId());

            if (fromClient.getPerson() != null) {
                if (fromClient.getPerson().getId() == null) {
                    PersonEntity newPerson = new PersonEntity();
                    newPerson.setFirstName(fromClient.getPerson().getFirstName());
                    newPerson.setLastName(fromClient.getPerson().getLastName());
                    newPerson.setMiddleName(fromClient.getPerson().getMiddleName());
                    newPerson.setBirthDay(fromClient.getPerson().getBirthDay());
                    newPerson.setNumberPhone(fromClient.getPerson().getNumberPhone());
                    personRepository.save(newPerson);
                    loadFromDb.setPerson(newPerson);
                } else {
                    PersonEntity personFromClient = fromClient.getPerson();
                    Optional<PersonEntity> optionalPerson = personRepository.findById(personFromClient.getId());
                    if (optionalPerson.isPresent()) {
                        loadFromDb.setPerson(optionalPerson.get());
                    } else {
                        throw new EntityNotFoundException("Person with id " + personFromClient.getId() + " not found");
                    }
                }
            }
            loadFromDb.setAcademicDegree(fromClient.getAcademicDegree());
            repository.save(loadFromDb);
        }
    }

    @Override
    protected TeacherEntity createEmptyEntity() {
        return new TeacherEntity();
    }
}

