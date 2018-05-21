package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.crm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
