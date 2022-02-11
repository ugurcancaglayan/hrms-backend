package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.VerificationCodeService;
import kodlamaio.HRMS.core.services.validationService.GenerateRandomCode;
import kodlamaio.HRMS.core.utilities.results.*;
import kodlamaio.HRMS.repository.VerificationCodeDao;
import kodlamaio.HRMS.model.VerificationCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VerificationCodeManager implements VerificationCodeService {

    private final VerificationCodeDao verificationCodeDao;

    @Override
    public DataResult<List<VerificationCode>> getAll() {
        return new SuccessDataResult<>(
                this.verificationCodeDao.findAll(),
                "Doğrulama kodları listelendi.");
    }

    @Override
    public void generateCode(VerificationCode verificationCode, Integer id) {

        GenerateRandomCode generator = new GenerateRandomCode();
        String createCode = generator.create();
        verificationCode.setActivationCode(createCode);
        verificationCode.setUserId(id);
        verificationCode.setVerified(true);

        verificationCodeDao.save(verificationCode);
    }

    @Override
    public Result verify(String verificationCode, Integer id) {

        VerificationCode verify = verificationCodeDao.findByUserId(id).stream().findFirst().get();

        if (verificationCodeDao.findById(id).isPresent() || verificationCodeDao.findByUserId(id).isEmpty()) {
            return new ErrorResult("Id değerini yanlış veya boş girdiniz!");
        }
        if (!verify.getActivationCode().equals(verificationCode)) {
            return new ErrorResult("Doğrulama kodu geçersiz.");
        }
        if (verify.isVerified() == true) {
            return new ErrorResult("Hesap zaten doğrulanmış.");
        } else /*(verify.getActivationCode().equals(verificationCode) && verify.isVerified() != true) */ {
            verify.setVerified(true);
            this.verificationCodeDao.save(verify);
            return new SuccessResult("Kullanıcı doğrulandı.");
        }

    }
}
