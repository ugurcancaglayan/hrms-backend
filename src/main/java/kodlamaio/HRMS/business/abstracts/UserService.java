package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    Result add(User user);
    DataResult<List<User>> getAll();
}
