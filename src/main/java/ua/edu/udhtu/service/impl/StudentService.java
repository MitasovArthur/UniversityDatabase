package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.PersonEntity;
import ua.edu.udhtu.model.entity.StudentEntity;
import ua.edu.udhtu.repository.PersonRepository;
import ua.edu.udhtu.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class StudentService extends BasedService<StudentEntity, Long> {
    private final PersonRepository personRepository;

    @Autowired
    public StudentService(StudentRepository repository, PersonRepository personRepository) {
        super(StudentEntity.class, repository);
        this.personRepository = personRepository;
    }
    @Override
    protected void fillEntity(StudentEntity loadFromDb, StudentEntity fromClient) {
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

            loadFromDb.setEducationType(fromClient.getEducationType());
            loadFromDb.setAddress(fromClient.getAddress());
            loadFromDb.setEmail(fromClient.getEmail());
        }
    }
}
