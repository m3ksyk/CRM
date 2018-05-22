package pl.coderslab.crm.service;

import org.springframework.stereotype.Service;
import pl.coderslab.crm.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;

    }
}
