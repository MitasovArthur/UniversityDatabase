
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
}
