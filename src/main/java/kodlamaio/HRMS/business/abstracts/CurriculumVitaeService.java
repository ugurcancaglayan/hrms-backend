package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.CurriculumVitae;
import kodlamaio.HRMS.dto.model.CvDto;

import java.util.List;

public interface CurriculumVitaeService {
    Result add(CvDto cvDto);
    Result deleteById(int id);
    DataResult<List<CurriculumVitae>> getAll();
    DataResult<List<CurriculumVitae>> findAllByIsActive();
}
