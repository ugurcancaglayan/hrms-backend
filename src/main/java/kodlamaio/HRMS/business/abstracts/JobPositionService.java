package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.JobPosition;

import java.util.List;

public interface JobPositionService {
    Result add(JobPosition jobPosition);
    Result deleteById(int id);
    DataResult<List<JobPosition>> getAll();
}