package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.CvJobExperienceService;
import kodlamaio.HRMS.core.services.converter.DtoConverterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CvJobExperienceDao;
import kodlamaio.HRMS.entities.concretes.CvJobExperince;
import kodlamaio.HRMS.entities.dtos.CvJobExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvJobExperienceManager implements CvJobExperienceService {

    private CvJobExperienceDao cvJobExperienceDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public CvJobExperienceManager(CvJobExperienceDao cvJobExperienceDao, DtoConverterService dtoConverterService) {
        this.cvJobExperienceDao = cvJobExperienceDao;
        this.dtoConverterService = dtoConverterService;
    }

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
