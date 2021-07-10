package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.JobPositionService;
import kodlamaio.HRMS.core.utilities.results.*;
import kodlamaio.HRMS.dataAccess.abstracts.JobPositionDao;
import kodlamaio.HRMS.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Result add(JobPosition jobPosition) {
        if (jobPositionDao.findByPosition(jobPosition.getPosition()) != null) {
            return new ErrorResult("Bu iş pozisyonu zaten sistemde kayıtlı!");
        }
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("İş pozisyonu eklendi!");
    }

    @Override
    public Result deleteById(int id) {
        if (!jobPositionDao.findById(id).isPresent()) {
            return new ErrorResult("Bu iş pozisyonu zaten silinmiş veya sistemde kayıtlı değil!");
        }
        this.jobPositionDao.deleteById(id);
        return new SuccessResult("İş pozisyonu silindi!");
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(
                this.jobPositionDao.findAll(),
                "İş pozisyonları listelendi!");
    }

}
