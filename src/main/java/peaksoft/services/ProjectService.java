package peaksoft.services;

import peaksoft.entity.Project;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public interface ProjectService {
    Project saveProject(Project project);
    String saveProjects(List<Project> projects);
    List<Project> getAllProjects();
    Project findById(Long id);
    String removeById(Long id);
    String removeAllProjects();
    Project updateProject(Long id, Project project);
    String assignProgrammerToProject(Long progId, Long projId);
    Project findTheBestExpensiveProject();
    //Name and duration
    Project findTheFastWrittenProject();
}
