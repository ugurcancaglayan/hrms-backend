package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
    JobSeeker findByEmail(String email);
    JobSeeker findByEmailAndPassword(String email, String password);
    JobSeeker findByNationalId(long nationalId);
}
