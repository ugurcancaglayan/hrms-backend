package kodlamaio.HRMS.repository;

import kodlamaio.HRMS.model.CvLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer> {
    List<CvLanguage> findAllByCurriculumVitae_Id(int id);
}
