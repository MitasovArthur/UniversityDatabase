
package ua.edu.udhtu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.PersonEntity;
import ua.edu.udhtu.repository.PersonRepository;

@Service
public class PersonService extends BasedService<PersonEntity, Long> {
    @Autowired
    public PersonService(PersonRepository repository) {
        super(PersonEntity.class, repository);
    }

    @Override
    protected void fillEntity(PersonEntity loadFromDb, PersonEntity fromClient) {
        if (loadFromDb == null || fromClient == null) {
            throw new IllegalArgumentException("Both source and target entities must not be null");
        }
        loadFromDb.setFirstName(fromClient.getFirstName());
        loadFromDb.setLastName(fromClient.getLastName());
        loadFromDb.setMiddleName(fromClient.getMiddleName());
        loadFromDb.setBirthDay(fromClient.getBirthDay());
        loadFromDb.setNumberPhone(fromClient.getNumberPhone());
    }

    @Override
    protected PersonEntity createEmptyEntity() {
        return new PersonEntity();
    }
}
