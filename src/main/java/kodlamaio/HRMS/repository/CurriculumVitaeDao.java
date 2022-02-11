package kodlamaio.HRMS.repository;

import kodlamaio.HRMS.model.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {
    List<CurriculumVitae> findAllByIsActive(boolean isActive);
}
