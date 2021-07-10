package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İş ilanı sisteme eklendi.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByIsActive(boolean isActive) {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.findAllByIsActive(isActive), "İş ilanları listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive) {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.findAllByIsActiveOrderByCreatedDateDesc(isActive), "İş ilanları tarihe göre listelendi");
    }
}
