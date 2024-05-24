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
    private final TimeTableOfClassFactory timeTableOfClassFactory = new TimeTableOfClassFactory();

    public FactoryConfig() {
        {//Student
            studentFactory.setPersonFactory(personFactory);
            studentFactory.setStudyGroupFactory(studyGroupFactory);
            studentFactory.setActivityFactory(activityFactory);
        }
        {//teacher
            teacherFactory.setPersonFactory(personFactory);
            teacherFactory.setStudyGroupFactory(studyGroupFactory);
            teacherFactory.setGradeBookFactory(gradeBookFactory);
            teacherFactory.setSubjectFactory(subjectFactory);
            teacherFactory.setTimeTableOfClassFactory(timeTableOfClassFactory);
        }
        {//Activity
            activityFactory.setSubjectFactory(subjectFactory);
            activityFactory.setStudentFactory(studentFactory);
            activityFactory.setGradeBookFactory(gradeBookFactory);

        }
        {//Classroom
            classroomFactory.setTimeTableOfClassFactory(timeTableOfClassFactory);
        }
        {//StudyGroup
            studyGroupFactory.setTeacherFactory(teacherFactory);
            studyGroupFactory.setStudentFactory(studentFactory);
            studyGroupFactory.setSubjectFactory(subjectFactory);
            studyGroupFactory.setGradeBookFactory(gradeBookFactory);
            studyGroupFactory.setTimeTableOfClassFactory(timeTableOfClassFactory);
        }
        {//GradeBook
            gradeBookFactory.setSubjectFactory(subjectFactory);
            gradeBookFactory.setTeacherFactory(teacherFactory);
            gradeBookFactory.setStudyGroupFactory(studyGroupFactory);
            gradeBookFactory.setActivityFactory(activityFactory);
        }
        {//Subject
            subjectFactory.setStudyGroupFactory(studyGroupFactory);
            subjectFactory.setActivityFactory(activityFactory);
            subjectFactory.setGradeBookFactory(gradeBookFactory);
            subjectFactory.setTeacherFactory(teacherFactory);
            subjectFactory.setTimeTableOfClassFactory(timeTableOfClassFactory);
        }
        {//TimeTableOfClass
            timeTableOfClassFactory.setTeacherFactory(teacherFactory);
            timeTableOfClassFactory.setStudyGroupFactory(studyGroupFactory);
            timeTableOfClassFactory.setSubjectFactory(subjectFactory);
            timeTableOfClassFactory.setClassroomFactory(classroomFactory);

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

    @Bean
    public GradeBookFactory getGradeBookFactory() {
        return gradeBookFactory;
    }

    @Bean
    public ActivityFactory getActivityFactory() {
        return activityFactory;
    }

    @Bean
    public StudyGroupFactory getStudyGroupFactory() {
        return studyGroupFactory;
    }

    @Bean
    public TimeTableOfClassFactory getTimeTableOfClassFactory() {
        return timeTableOfClassFactory;
    }
}


