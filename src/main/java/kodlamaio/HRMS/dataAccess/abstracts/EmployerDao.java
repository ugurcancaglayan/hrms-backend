package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer findByEmail(String email);

    //List<Employer> findAllByIsActive(boolean isActive);
}
