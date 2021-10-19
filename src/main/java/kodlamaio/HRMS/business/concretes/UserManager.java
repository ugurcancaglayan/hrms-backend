package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.utilities.results.*;
import kodlamaio.HRMS.dataAccess.abstracts.UserDao;
import kodlamaio.HRMS.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

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
