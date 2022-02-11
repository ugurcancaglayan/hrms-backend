package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.Employer;

import java.util.List;

public interface EmployerService {
    Result add(Employer employer);
    Result deleteById(int id);
    DataResult<List<Employer>> getAll();
    DataResult<Employer> findByEmailAndPassword(String email, String password);
}
