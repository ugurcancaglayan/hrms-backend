package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.VerificationCode;

import java.util.List;

public interface VerificationCodeService {
    DataResult<List<VerificationCode>> getAll();
    void generateCode(VerificationCode verificationCode, Integer id);
    Result verify(String verificationCode, Integer id);
}
