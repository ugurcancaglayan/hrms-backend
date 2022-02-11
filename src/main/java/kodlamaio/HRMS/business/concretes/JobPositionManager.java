package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.JobPositionService;
import kodlamaio.HRMS.core.utilities.results.*;
import kodlamaio.HRMS.repository.JobPositionDao;
import kodlamaio.HRMS.model.JobPosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JobPositionManager implements JobPositionService {

    private final JobPositionDao jobPositionDao;

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
