package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.crm.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository <Activity, Long> {
}
