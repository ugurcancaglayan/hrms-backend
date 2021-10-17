package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.CvJobExperince;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvJobExperienceDao extends JpaRepository<CvJobExperince, Integer> {
}
