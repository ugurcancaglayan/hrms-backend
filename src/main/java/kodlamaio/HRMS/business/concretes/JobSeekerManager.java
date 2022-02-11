package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.business.abstracts.VerificationCodeService;
import kodlamaio.HRMS.core.services.mernisService.MernisService;
import kodlamaio.HRMS.core.utilities.results.*;
import kodlamaio.HRMS.repository.JobSeekerDao;
import kodlamaio.HRMS.model.JobSeeker;
import kodlamaio.HRMS.model.VerificationCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JobSeekerManager implements JobSeekerService {

    private final JobSeekerDao jobSeekerDao;
    private final VerificationCodeService verificationCodeService;

    VerificationCode verificationCode = new VerificationCode();

    public boolean validationJobSeeker(JobSeeker jobSeeker) throws MalformedURLException {
        if (new MernisService().validatePersonalInfo(
                jobSeeker.getNationalId(),
                jobSeeker.getFirstName(),
                jobSeeker.getLastName(),
                jobSeeker.getDateOfBirth().getYear())) {
            return true;
        }
        return false;
    }

    @Override
    public Result add(JobSeeker jobSeeker, String confirmPassword) throws MalformedURLException {

            if (!validationJobSeeker(jobSeeker)) {
                return new ErrorResult("The credentials you entered are incorrect!");
            }
            if (jobSeekerDao.findByEmail(jobSeeker.getEmail()) != null) {
                return new ErrorResult("This email address is already registered!");
            }
            if (jobSeekerDao.findByNationalId(jobSeeker.getNationalId()) != null) {
                return new ErrorResult("This national ID number is already registered!");
            }
            if (!jobSeeker.getPassword().equals(confirmPassword)) {
                return new ErrorResult("Passwords don't match!");
            }

            this.jobSeekerDao.save(jobSeeker);
            /*this.verificationCodeService.generateCode(new VerificationCode(), jobSeeker.getId());
            verificationCode.setVerified(true);*/
            return new SuccessResult("Job seeker saved successfully.");
    }

    @Override
    public Result deleteById(int id) {
        this.jobSeekerDao.deleteById(id);
        return new SuccessResult("Job seeker deleted successfully.");
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(
                this.jobSeekerDao.findAll(),
                "Job seekers listed successfully.");
    }

    @Override
    public DataResult<JobSeeker> findByEmailAndPassword(String email, String password) {
        return new SuccessDataResult<>(
                this.jobSeekerDao.findByEmailAndPassword(email, password),
                "Job seeker listed successfully.");
    }

}
