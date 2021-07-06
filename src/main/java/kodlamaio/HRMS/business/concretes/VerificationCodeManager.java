package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.VerificationCodeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.HRMS.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationCodeManager implements VerificationCodeService {

    private VerificationCodeDao verificationCodeDao;

    @Autowired
    public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
        this.verificationCodeDao = verificationCodeDao;
    }

    @Override
    public DataResult<List<VerificationCode>> getAll() {
        return new SuccessDataResult<>(
                this.verificationCodeDao.findAll(),
                "Doğrulama kodları listelendi.");
    }

    @Override
    public Result add(VerificationCode verificationCode) {
        this.verificationCodeDao.save(verificationCode);
            return new SuccessResult("Doğrulama kodu başarıyla eklendi.");
    }
}
