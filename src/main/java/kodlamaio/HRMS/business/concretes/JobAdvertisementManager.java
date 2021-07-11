package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.*;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;
    private EmployerDao employerDao;

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
    public DataResult<List<JobAdvertisement>> findAllByIsActive() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.findAllByIsActive(true),
                "Aktif iş ilanları listelendi.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByIsActiveOrderByCreatedDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.findAllByIsActiveOrderByCreatedDateDesc(true),
                "İş ilanları tarihe göre listelendi.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getEmployersActiveJobAdvertisement(int id) {

        if (this.jobAdvertisementDao.existsByEmployerId(id).isEmpty()) {
            return new ErrorDataResult<List<JobAdvertisement>>("İş veren bulunamadı.");
        }
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.getEmployersActiveJobAdvertisement(id),
                "İş verenin aktif iş ilanları listelendi.");
    }

    @Override
    public DataResult<JobAdvertisement> setJobAdvertisementDisabled(int id) {

        if (!this.jobAdvertisementDao.findById(id).isPresent()) {
            return new ErrorDataResult<JobAdvertisement>("İş ilanı bulunamadı.");
        }
        if (!this.jobAdvertisementDao.alreadyDisabled(id).isEmpty()) {
            return new ErrorDataResult<JobAdvertisement>("İş ilanı zaten pasif durumda.");
        }
        JobAdvertisement jobAdvertisement = jobAdvertisementDao.getById(id);
        jobAdvertisement.setActive(false);
        return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(jobAdvertisement),
                "İş ilanı pasif olarak ayarlandı.");
    }
}
