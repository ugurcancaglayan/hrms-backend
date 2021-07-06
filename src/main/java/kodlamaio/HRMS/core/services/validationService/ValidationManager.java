package kodlamaio.HRMS.core.services.validationService;

import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.HRMS.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ValidationManager implements ValidationService {

    private VerificationCodeDao verificationCodeDao;

    @Autowired
    public ValidationManager(VerificationCodeDao verificationCodeDao) {
        this.verificationCodeDao = verificationCodeDao;
    }

    @Override
    public void generateCode(VerificationCode verificationCode, Integer id) {

        GenerateRandomCode generator = new GenerateRandomCode();
        String createCode = generator.create();
        verificationCode.setActivationCode(createCode);
        verificationCode.setUserId(id);

        verificationCodeDao.save(verificationCode);
    }

    @Override
    public Result verify(String verificationCode, Integer id) {

        VerificationCode verify = verificationCodeDao.findByUserId(id).stream().findFirst().get();
        VerificationCode verificationCode1 = new VerificationCode();
        
        if (verify.getActivationCode().equals(verificationCode) && verify.isVerified() != true) {
            verify.setVerified(true);
            this.verificationCodeDao.save(verify);
            return new SuccessResult("Kullanıcı doğrulandı.");
        }
        if (!verify.getActivationCode().equals(verificationCode)) {
            return new ErrorResult("Doğrulama kodu geçersiz.");
        }
        if (verify.isVerified() == true) {
            return new ErrorResult("Hesap zaten doğrulanmış.");
        }
        else {
            return new ErrorResult("Beklenmedik hata.");
        }
    }
}
