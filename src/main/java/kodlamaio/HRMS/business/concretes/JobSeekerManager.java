package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.business.abstracts.VerificationCodeService;
import kodlamaio.HRMS.core.services.mernisService.MernisService;
import kodlamaio.HRMS.core.services.validationService.ValidationService;
import kodlamaio.HRMS.core.utilities.results.*;
import kodlamaio.HRMS.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.HRMS.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.HRMS.entities.concretes.JobSeeker;
import kodlamaio.HRMS.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.List;
import java.util.UUID;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private VerificationCodeService verificationCodeService;
    private ValidationService validationService;
    VerificationCode verificationCode = new VerificationCode();

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, VerificationCodeService verificationCodeService, ValidationService validationService) {
        this.jobSeekerDao = jobSeekerDao;
        this.verificationCodeService = verificationCodeService;
        this.validationService = validationService;
    }

    public boolean validationJobSeeker(JobSeeker jobSeeker) throws MalformedURLException {
        if (new MernisService().validatePersonalInfo(
                jobSeeker.getNationalId(),
                jobSeeker.getFirstName(),
                jobSeeker.getLastName(),
                jobSeeker.getDateOfBirth())) {
            return true;
        }
        return false;
    }

    public boolean checkNullInfoForJobSeeker(JobSeeker jobSeeker, String confirmPassword) {
        if (jobSeeker.getFirstName() != null &&
            jobSeeker.getLastName() != null &&
            jobSeeker.getNationalId() != 0 &&
            jobSeeker.getDateOfBirth() != 0 &&
            jobSeeker.getEmail() != null &&
            jobSeeker.getPassword() != null &&
            confirmPassword != null) {
            return true;
        }
        return false;
    }

    @Override
    public Result add(JobSeeker jobSeeker, String confirmPassword) throws MalformedURLException {

            if (!checkNullInfoForJobSeeker(jobSeeker, confirmPassword)) {
                return new ErrorResult("Eksik bilgiler mevcut. " +
                        "Tüm boşlukları doldurunuz!");
            }
            if (!validationJobSeeker(jobSeeker)) {
                return new ErrorResult("Girdiğiniz kimlik bilgileri hatalı!");
            }
            if (jobSeekerDao.findByEmail(jobSeeker.getEmail()) != null) {
                return new ErrorResult("Bu e-posta adresi zaten kayıtlı!");
            }
            if (jobSeekerDao.findByNationalId(jobSeeker.getNationalId()) != null) {
                return new ErrorResult("Bu kimlik numarası zaten kayıtlı!");
            }
            if (!jobSeeker.getPassword().equals(confirmPassword)) {
                return new ErrorResult("Şifreler uyuşmuyor!");
            }

            this.jobSeekerDao.save(jobSeeker);
            this.validationService.generateCode(new VerificationCode(), jobSeeker.getId());
            verificationCode.setVerified(true);
            return new SuccessResult("İş arayan kullanıcı eklendi.");
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(
                this.jobSeekerDao.findAll(),
                "İş arayan kullanıcılar listelendi.");
    }
}
