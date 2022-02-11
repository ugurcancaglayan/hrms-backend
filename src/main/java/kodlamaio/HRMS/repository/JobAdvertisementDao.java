package kodlamaio.HRMS.repository;

import kodlamaio.HRMS.model.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findAllByIsActive(boolean isActive);

    List<JobAdvertisement> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive);

    @Query("from JobAdvertisement where isActive = true and employer.id =:id")
    List<JobAdvertisement> getEmployersActiveJobAdvertisement(int id);

    @Query("from JobAdvertisement where employer.id=:id")
    List<JobAdvertisement> existsByEmployerId(int id);

    @Query("from JobAdvertisement where id=:id and isActive = false")
    List<JobAdvertisement> alreadyDisabled(int id);
}
