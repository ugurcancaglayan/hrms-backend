package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.User;

import java.util.List;

public interface UserService {
    Result add(User user);
    DataResult<List<User>> getAll();
}