package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.*;
import kodlamaio.HRMS.repository.EmployerDao;
import kodlamaio.HRMS.repository.JobAdvertisementDao;
import kodlamaio.HRMS.model.JobAdvertisement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private final JobAdvertisementDao jobAdvertisementDao;
    private final EmployerDao employerDao;

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Job advertisement saved successfully.");
    }

    @Override
    public DataResult<JobAdvertisement> getById(int id) {
        return new SuccessDataResult<JobAdvertisement>(
                this.jobAdvertisementDao.getById(id),
                "Job advertisement listed successfully.");
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

    @Override
    public DataResult<List<JobAdvertisement>> filterJobs(int cityId, int workTimeId, int workTypeId) {
        List<JobAdvertisement> result = new ArrayList<JobAdvertisement>();

        Stream<JobAdvertisement> stream = findAllByIsActive().getData().stream();

        Predicate<JobAdvertisement> cityCondition = cityId != 0
                ? (jobAdvertisement -> jobAdvertisement.getCity().getId() == cityId)
                : (jobAdvertisement -> jobAdvertisement.getCity().getId() > 0);
        Predicate<JobAdvertisement> workTimeCondition = workTimeId != 0
                ? (jobAdvertisement -> jobAdvertisement.getWorkTime().getId() == workTimeId)
                : (jobAdvertisement -> jobAdvertisement.getWorkTime().getId() > 0);
        Predicate<JobAdvertisement> workTypeCondition = workTypeId != 0
                ? (jobAdvertisement -> jobAdvertisement.getWorkType().getId() == workTypeId)
                : (jobAdvertisement -> jobAdvertisement.getWorkType().getId() > 0);

        stream.filter(cityCondition).filter(workTimeCondition).filter(workTypeCondition).forEach(jobAdvertisement -> result.add(jobAdvertisement));

        return new SuccessDataResult<List<JobAdvertisement>>(result);
    }
}
