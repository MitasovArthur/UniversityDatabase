package ua.edu.udhtu.Factory;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ua.edu.udhtu.Factory.impl.ClassroomFactory;
import ua.edu.udhtu.Factory.impl.PersonFactory;
import ua.edu.udhtu.Factory.impl.StudentFactory;

@Component
public class FactoryConfig {
    private final PersonFactory personFactory = new PersonFactory();
    private final StudentFactory studentFactory = new StudentFactory();
    private final ClassroomFactory classroomFactory = new ClassroomFactory();

    public FactoryConfig() {
        {//Student
            studentFactory.setPersonFactory(personFactory);
        }

    }

    @Bean
    public PersonFactory getPersonFactory() {
        return personFactory;
    }

    @Bean
    public StudentFactory getStudentFactory() {
        return studentFactory;
    }

    @Bean
    public ClassroomFactory getClassroomFactory() {
        return classroomFactory;
    }
}


