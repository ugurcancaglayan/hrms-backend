package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployerService {
    Result add(Employer employer, String confirmPassword);
    DataResult<List<Employer>> getAll();
}
