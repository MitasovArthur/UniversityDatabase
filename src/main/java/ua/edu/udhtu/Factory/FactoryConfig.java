package ua.edu.udhtu.Factory;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ua.edu.udhtu.Factory.impl.ClassroomFactory;
import ua.edu.udhtu.Factory.impl.PersonFactory;
import ua.edu.udhtu.Factory.impl.StudentFactory;
import ua.edu.udhtu.Factory.impl.TeacherFactory;

@Component
public class FactoryConfig {
    private final PersonFactory personFactory = new PersonFactory();
    private final StudentFactory studentFactory = new StudentFactory();
    private final TeacherFactory teacherFactory = new TeacherFactory();
    private final ClassroomFactory classroomFactory = new ClassroomFactory();
//    private final StudyGroupFactory studyGroupFactory = new StudyGroupFactory();

    public FactoryConfig() {
        {//Student
            studentFactory.setPersonFactory(personFactory);
        }
        {//teacher
            teacherFactory.setPersonFactory(personFactory);
//            teacherFactory.setStudyGroupFactory();
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
    public TeacherFactory getTeacherFactory() {
        return teacherFactory;
    }

    @Bean
    public ClassroomFactory getClassroomFactory() {
        return classroomFactory;
    }
}


