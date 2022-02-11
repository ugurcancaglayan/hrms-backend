package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.CvJobExperienceService;
import kodlamaio.HRMS.dto.mapper.DtoConverterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.repository.CvJobExperienceDao;
import kodlamaio.HRMS.model.CvJobExperince;
import kodlamaio.HRMS.dto.model.CvJobExperienceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CvJobExperienceManager implements CvJobExperienceService {

    private final CvJobExperienceDao cvJobExperienceDao;
    private final DtoConverterService dtoConverterService;

    @Override
    public Result add(CvJobExperienceDto cvJobExperince) {
        this.cvJobExperienceDao.save((CvJobExperince) dtoConverterService.dtoClassConverter(cvJobExperince, CvJobExperince.class));
        return new SuccessResult("Job experience saved successfully.");
    }

    @Override
    public Result deleteById(int id) {
        this.cvJobExperienceDao.deleteById(id);
        return new SuccessResult("Job experience deleted successfully.");
    }

    @Override
    public DataResult<List<CvJobExperince>> getAll() {
        return new SuccessDataResult<List<CvJobExperince>>(
                this.cvJobExperienceDao.findAll(),
                "Job experiences listed successfully."
        );
    }
}
