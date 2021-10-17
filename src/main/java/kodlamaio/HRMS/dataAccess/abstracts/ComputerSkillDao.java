package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.CvComputerSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerSkillDao extends JpaRepository<CvComputerSkill, Integer> {
}
