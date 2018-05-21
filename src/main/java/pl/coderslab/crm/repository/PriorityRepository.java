package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.crm.entity.Priority;

@Repository
public interface PriorityRepository extends JpaRepository <Priority, Long> {
}
