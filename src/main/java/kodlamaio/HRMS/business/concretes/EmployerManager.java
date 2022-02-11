package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.business.abstracts.VerificationCodeService;
import kodlamaio.HRMS.core.utilities.results.*;
import kodlamaio.HRMS.repository.EmployerDao;
import kodlamaio.HRMS.repository.VerificationCodeDao;
import kodlamaio.HRMS.model.Employer;
import kodlamaio.HRMS.model.VerificationCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;
    private final VerificationCodeService verificationCodeService;
    private final VerificationCodeDao verificationCodeDao;

    public boolean checkEmail(Employer employer) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employer.getEmail());
        if (!matcher.matches()) {
            new ErrorResult("Invalid email address!");
            return false;
        } else if (!employer.getEmail().contains(employer.getWebSite())) {
            new ErrorResult("You have to enter the domain address!");
            return false;
        }
        return true;
    }

    private boolean checkPhoneNumber(Employer employer) {
        String patterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(employer.getPhoneNumber());
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    @Override
    public Result add(Employer employer) {

        if (!checkEmail(employer)) {
            return new ErrorResult("Enter the email format correctly!");
        }
        if (!checkPhoneNumber(employer)) {
            return new ErrorResult("Please enter a valid phone number!");
        }
        if (employerDao.findByEmail(employer.getEmail()) != null) {
            return new ErrorResult("This email address is already registered!");
        }

        this.employerDao.save(employer);
        this.verificationCodeService.generateCode(new VerificationCode(), employer.getId());
        return new SuccessResult("Employer saved successfully.");
    }

    @Override
    public Result deleteById(int id) {
        this.employerDao.deleteById(id);
        return new SuccessResult("Employer deleted successfully.");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(
                this.employerDao.findAll(),
                "Employers listed successfully.");
    }

    @Override
    public DataResult<Employer> findByEmailAndPassword(String email, String password) {
        return new SuccessDataResult<>(
                this.employerDao.findByEmailAndPassword(email, password),
                "Employer listed successfully.");
    }
}
