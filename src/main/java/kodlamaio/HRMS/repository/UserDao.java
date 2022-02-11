package kodlamaio.HRMS.repository;

import kodlamaio.HRMS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
