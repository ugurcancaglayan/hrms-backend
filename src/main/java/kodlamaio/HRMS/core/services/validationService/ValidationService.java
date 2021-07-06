package kodlamaio.HRMS.core.services.validationService;

import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.VerificationCode;
import org.springframework.stereotype.Service;

@Service
public interface ValidationService {
    void generateCode(VerificationCode verificationCode, Integer id);
    Result verify(String verificationCode, Integer id);
}
