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
        return new SuccessResult("Job advertisement saved successfully.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByIsActive() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.findAllByIsActive(true),
                "Active job advertisement listed successfully.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByIsActiveOrderByCreatedDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.findAllByIsActiveOrderByCreatedDateDesc(true),
                "Job advertisements are listed by date.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getEmployersActiveJobAdvertisement(int id) {

        if (this.jobAdvertisementDao.existsByEmployerId(id).isEmpty()) {
            return new ErrorDataResult<List<JobAdvertisement>>("Employer not found.");
        }
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.getEmployersActiveJobAdvertisement(id),
                "Active job advertisements of the employer are listed.");
    }

    @Override
    public DataResult<JobAdvertisement> setJobAdvertisementDisabled(int id) {

        if (!this.jobAdvertisementDao.findById(id).isPresent()) {
            return new ErrorDataResult<JobAdvertisement>("Job advertisement not found.");
        }
        if (!this.jobAdvertisementDao.alreadyDisabled(id).isEmpty()) {
            return new ErrorDataResult<JobAdvertisement>("Job advertisement is already inactive.");
        }
        JobAdvertisement jobAdvertisement = jobAdvertisementDao.getById(id);
        jobAdvertisement.setActive(false);
        return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(jobAdvertisement),
                "Job advertisement is set to passive.");
    }
}
