package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {

    Result add(JobAdvertisement jobAdvertisement);

    DataResult<List<JobAdvertisement>> findAllByIsActive(boolean isActive);

    DataResult<List<JobAdvertisement>> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive);

}
