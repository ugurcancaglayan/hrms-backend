package kodlamaio.HRMS.repository;

import kodlamaio.HRMS.model.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTimeDao extends JpaRepository<WorkTime, Integer> {
}
