package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.WorkType;

import java.util.List;

public interface WorkTypeService {
    Result add(WorkType workType);
    DataResult<List<WorkType>> getAll();
}
