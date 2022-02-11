package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.WorkTimeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.repository.WorkTimeDao;
import kodlamaio.HRMS.model.WorkTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WorkTimeManager implements WorkTimeService {

    private final WorkTimeDao workTimeDao;

    @Override
    public Result add(WorkTime workTime) {
        this.workTimeDao.save(workTime);
        return new SuccessResult("Work types saved successfully.");
    }

    @Override
    public DataResult<List<WorkTime>> getAll() {
        return new SuccessDataResult<>(
                this.workTimeDao.findAll(),
                "Work times listed successfully.");
    }
}
