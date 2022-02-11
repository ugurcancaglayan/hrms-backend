package kodlamaio.HRMS.repository;

import kodlamaio.HRMS.model.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    JobPosition findByPosition(String jobPosition);
}
