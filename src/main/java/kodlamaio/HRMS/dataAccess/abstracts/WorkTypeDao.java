package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTypeDao extends JpaRepository<WorkType, Integer> {
}
