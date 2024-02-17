
package ua.edu.udhtu.service;

import org.springframework.stereotype.Service;
import ua.edu.udhtu.model.entity.PersonEntity;
import ua.edu.udhtu.repository.PersonRepository;
import ua.edu.udhtu.service.impl.BasedService;

@Service
public class PersonService extends BasedService<PersonEntity, Long> {
    public PersonService(PersonRepository repository) {
        super(PersonEntity.class, repository);
    }
}
