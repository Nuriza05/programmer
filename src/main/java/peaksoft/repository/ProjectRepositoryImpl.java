package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Programmer;
import peaksoft.entity.Project;
import peaksoft.enums.Status;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public class ProjectRepositoryImpl implements ProjectRepository, AutoCloseable{
    EntityManagerFactory entityManagerFactory = (EntityManagerFactory) HibernateConfig.getEntityManager();
    @Override
    public Project saveProject(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        entityManager.close();
        return project;
    }

    @Override
    public String saveProjects(List<Project> projects) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Project project : projects) {
            entityManager.persist(project);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Projects are successfully saved";
    }

    @Override
    public List<Project> getAllProjects() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Project> fromProject = entityManager.createQuery("from Project ", Project.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return fromProject;
    }

    @Override
    public Project findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project selectLFromProject = entityManager.createQuery("select l from Project l where l.id = : id ", Project.class).setParameter("id",id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return selectLFromProject;
    }

    @Override
    public String removeById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project id1 = entityManager.createQuery("select l from Project l where l.id =: id", Project.class).setParameter("id", id).getSingleResult();
        entityManager.persist(id1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Project is successfully removed!";
    }

    @Override
    public String removeAllProjects() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete Project ", Project.class);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Projects are successfully deleted!";
    }

    @Override
    public Project updateProject(Long id, Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project singleResult = entityManager.createQuery("select l from Project l where l.id =: id", Project.class).setParameter("id",id).getSingleResult();
        singleResult.setProjectName(project.getProjectName());
        singleResult.setDescription(project.getDescription());
        singleResult.setDateOfFinish(project.getDateOfFinish());
        singleResult.setDateOfStart(project.getDateOfStart());
        singleResult.setPrice(project.getPrice());
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public String assignProgrammerToProject(Long progId, Long projId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Programmer prog = entityManager.createQuery("select l from Programmer l where l.id =: id", Programmer.class).setParameter("id", progId).getSingleResult();
        Project proj = entityManager.createQuery("select l from Project l where l.id =: id", Project.class).setParameter("id", projId).getSingleResult();
        prog.getProjects().add(proj);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Programmer is successfully assigned to project!";
    }

    @Override
    public Project findTheBestExpensiveProject() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project singleResult = entityManager.createQuery("select l from Project l order by price desc limit 1", Project.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public Project findTheFastWrittenProject() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project singleResult = entityManager.createQuery("select l from Project l order by dateOfFinish-dateOfStart limit 1", Project.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
