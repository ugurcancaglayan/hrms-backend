package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.CvSchool;
import kodlamaio.HRMS.dto.model.CvSchoolDto;

import java.util.List;

public interface CvSchoolsService {
    Result add(CvSchoolDto cvSchool);
    Result deleteById(int id);
    DataResult<List<CvSchool>> getAll();
}
