package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.crm.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository <Status, Long> {
}
