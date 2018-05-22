package pl.coderslab.crm.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.entity.Task;
import pl.coderslab.crm.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

    }
    @Override
    public List<Task> findAllTasksByProject(Optional<Project> project) {
        return taskRepository.findAllByProject(project);
    }
}
