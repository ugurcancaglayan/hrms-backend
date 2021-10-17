package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobPosition;
import kodlamaio.HRMS.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobPositionService {
    Result add(JobPosition jobPosition);
    Result deleteById(int id);
    DataResult<List<JobPosition>> getAll();
}
