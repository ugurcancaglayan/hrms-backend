package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.WorkTime;

import java.util.List;

public interface WorkTimeService {
    Result add(WorkTime workTime);
    DataResult<List<WorkTime>> getAll();
}
