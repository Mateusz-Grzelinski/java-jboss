package pl.agh.edu.kis;

import java.util.logging.Logger;

public class ProjectDao extends AbstractDao {

    private static final Logger LOGGER = Logger.getLogger(StudentDao.class.getName());

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<Project> getType() {
        return Project.class;
    }


}