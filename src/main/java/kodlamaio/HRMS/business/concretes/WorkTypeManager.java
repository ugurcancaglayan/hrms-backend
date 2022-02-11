package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.WorkTypeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.repository.WorkTypeDao;
import kodlamaio.HRMS.model.WorkType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WorkTypeManager implements WorkTypeService {

    private final WorkTypeDao workTypeDao;

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
