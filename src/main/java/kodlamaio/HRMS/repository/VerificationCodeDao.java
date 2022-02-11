package kodlamaio.HRMS.repository;

import kodlamaio.HRMS.model.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {
    List<VerificationCode> findByUserId(Integer userId);
}
