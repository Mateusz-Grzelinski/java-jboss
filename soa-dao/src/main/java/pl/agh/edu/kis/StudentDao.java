package pl.agh.edu.kis;


import javax.inject.Inject;
import java.util.logging.Logger;

public class StudentDao extends AbstractDao {

    private static final Logger LOGGER = Logger.getLogger(StudentDao.class.getName());

    @Inject
    ProjectDao projectDao;

    @Inject
    SubjectDao subjectDao;

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

//    @Override
//    public <T> void create(T object) {
//        if (object instanceof Student) {
//            Student student = (Student) object;
//
////            if (student.getProjects() != null)
////                for (Project project : student.getProjects()) {
////                    projectDao.createNewTransaction(project);
////                }
////
////            if (student.getSubjects() != null)
////                for (Subject subject : student.getSubjects()) {
////                    subjectDao.createNewTransaction(subject);
////                }
//            super.create(student);
//        }
//    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<Student> getType() {
        return Student.class;
    }


}
