package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.CvJobExperince;
import kodlamaio.HRMS.entities.dtos.CvJobExperienceDto;

import java.util.List;

public interface CvJobExperienceService {
    Result add(CvJobExperienceDto cvJobExperince);
    Result deleteById(int id);
    DataResult<List<CvJobExperince>> getAll();
}
