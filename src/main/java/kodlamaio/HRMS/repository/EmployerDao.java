package kodlamaio.HRMS.repository;

import kodlamaio.HRMS.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer findByEmail(String email);
    Employer findByEmailAndPassword(String email, String password);
    //List<Employer> findAllByIsActive(boolean isActive);
}
