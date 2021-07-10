package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findAllByIsActive(boolean isActive);

    List<JobAdvertisement> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive);
}
