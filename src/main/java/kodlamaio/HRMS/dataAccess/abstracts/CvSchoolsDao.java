package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.CvSchool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvSchoolsDao extends JpaRepository<CvSchool, Integer> {
}
