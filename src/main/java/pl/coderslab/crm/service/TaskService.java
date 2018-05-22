package pl.coderslab.crm.service;

import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAllTasksByProject(Optional<Project> project);

}
