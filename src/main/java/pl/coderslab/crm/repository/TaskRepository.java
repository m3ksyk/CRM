package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.entity.Task;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
    List<Task> findAllByProject(Optional<Project> project);
}
