package ua.edu.udhtu.Factory;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ua.edu.udhtu.Factory.impl.*;

@Component
public class FactoryConfig {
    private final PersonFactory personFactory = new PersonFactory();
    private final StudentFactory studentFactory = new StudentFactory();
    private final TeacherFactory teacherFactory = new TeacherFactory();
    private final ClassroomFactory classroomFactory = new ClassroomFactory();
    private final StudyGroupFactory studyGroupFactory = new StudyGroupFactory();
    private final ActivityFactory activityFactory = new ActivityFactory();
    private final SubjectFactory subjectFactory = new SubjectFactory();
    private final GradeBookFactory gradeBookFactory = new GradeBookFactory();

    public FactoryConfig() {
        {//Student
            studentFactory.setPersonFactory(personFactory);
        }
        {//teacher
            teacherFactory.setPersonFactory(personFactory);
            teacherFactory.setStudyGroupFactory(studyGroupFactory);
        }
        {//Activity
            activityFactory.setSubjectFactory(subjectFactory);
            activityFactory.setStudentFactory(studentFactory);
//        activityFactory.setGradeBookFactory(gradeBookFactory);

        }
        {//StudyGroup
        studyGroupFactory.setTeacherFactory(teacherFactory);
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

    @Bean
    public SubjectFactory getSubjectFactory() {
        return subjectFactory;
    }

//    @Bean
//    public GradeBookFactory getGradeBookFactory() {
//        return gradeBookFactory;
//    }

    @Bean
    public StudyGroupFactory getStudyGroupFactory() {
        return studyGroupFactory;
    }

    public ActivityFactory getActivityFactory() {
        return activityFactory;
    }
}


