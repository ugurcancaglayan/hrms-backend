package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.utilities.results.*;
import kodlamaio.HRMS.repository.UserDao;
import kodlamaio.HRMS.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserManager implements UserService {

    private final UserDao userDao;

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("User saved successfully.");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(
                this.userDao.findAll(),
                "Users listed successfully.");
    }

}
