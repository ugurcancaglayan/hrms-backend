package kodlamaio.HRMS.dataAccess.abstracts;

import kodlamaio.HRMS.entities.concretes.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {
    List<VerificationCode> findByUserId(Integer userId);
}
