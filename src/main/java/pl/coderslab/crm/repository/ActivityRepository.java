package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.crm.entity.Activity;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository <Activity, Long> {
    @Query(value = "SELECT * FROM Activity ORDER BY id DESC LIMIT 25", nativeQuery = true)
    List<Activity> findRecent();
}
