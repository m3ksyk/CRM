package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.crm.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
