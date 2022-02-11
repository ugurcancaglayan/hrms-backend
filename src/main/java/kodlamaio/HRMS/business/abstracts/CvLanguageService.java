package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.CvLanguage;
import kodlamaio.HRMS.dto.model.CvLanguageDto;

import java.util.List;

public interface CvLanguageService {
    Result add(CvLanguageDto cvLanguage);
    Result deleteById(int id);
    DataResult<List<CvLanguage>> getAll();
    DataResult<List<CvLanguage>> findAllByCvId(int id);
}
