package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.WorkTypeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.HRMS.entities.concretes.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTypeManager implements WorkTypeService {

    @Autowired
    private WorkTypeDao workTypeDao;

    public WorkTypeManager(WorkTypeDao workTypeDao) {
        this.workTypeDao = workTypeDao;
    }

    @Override
    public Result add(WorkType workType) {
        this.workTypeDao.save(workType);
        return new SuccessResult("Work types saved successfully.");
    }

    @Override
    public DataResult<List<WorkType>> getAll() {
        return new SuccessDataResult<>(
                this.workTypeDao.findAll(),
                "Work types listed successfully.");
    }
}
