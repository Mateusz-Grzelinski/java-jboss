package pl.agh.edu.kis;


import javax.inject.Inject;
import javax.persistence.criteria.*;
import javax.sound.midi.Soundbank;
import java.util.List;
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


    public List<Student> getByField(String student_name, String project_name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        SetJoin<Student, Subject> join1 = root.joinSet("subjects", JoinType.LEFT);
        ListJoin<Student, Project> join2 = root.joinList("projects", JoinType.LEFT);

        System.out.println(root.get("name"));
        System.out.println(join2.get("name"));

        if (project_name != null && !project_name.isEmpty())
            query.where(criteriaBuilder.and(
                    criteriaBuilder.equal(root.get("name"), student_name),
                    criteriaBuilder.equal(join2.get("name"), project_name)
                    )
            );
        else
            query.where(
                    criteriaBuilder.equal(root.get("name"), student_name)
            );


        query.distinct(true);
        return entityManager.createQuery(query).getResultList();
    }


    @SuppressWarnings("unchecked")
    @Override
    protected Class<Student> getType() {
        return Student.class;
    }


}
