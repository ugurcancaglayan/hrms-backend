package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.VerificationCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VerificationCodeService {
    DataResult<List<VerificationCode>> getAll();
    Result add(VerificationCode verificationCode);
}