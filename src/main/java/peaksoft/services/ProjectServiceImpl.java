package peaksoft.services;

import peaksoft.entity.Project;
import peaksoft.repository.ProjectRepository;
import peaksoft.repository.ProjectRepositoryImpl;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRep = new ProjectRepositoryImpl();

    @Override
    public Project saveProject(Project project) {
        return projectRep.saveProject(project);
    }

    @Override
    public String saveProjects(List<Project> projects) {
        return projectRep.saveProjects(projects);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRep.getAllProjects();
    }

    @Override
    public Project findById(Long id) {
        return projectRep.findById(id);
    }

    @Override
    public String removeById(Long id) {
        return projectRep.removeById(id);
    }

    @Override
    public String removeAllProjects() {
        return projectRep.removeAllProjects();
    }

    @Override
    public Project updateProject(Long id, Project project) {
        return projectRep.updateProject(id,project);
    }

    @Override
    public String assignProgrammerToProject(Long progId, Long projId) {
        return projectRep.assignProgrammerToProject(progId,projId);
    }

    @Override
    public Project findTheBestExpensiveProject() {
        return projectRep.findTheBestExpensiveProject();
    }

    @Override
    public Project findTheFastWrittenProject() {
        return projectRep.findTheFastWrittenProject();
    }
}
