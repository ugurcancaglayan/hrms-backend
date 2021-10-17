package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.CvLanguage;
import kodlamaio.HRMS.entities.dtos.CvLanguageDto;

import java.util.List;

public interface CvLanguageService {
    Result add(CvLanguageDto cvLanguage);
    Result deleteById(int id);
    DataResult<List<CvLanguage>> getAll();
    DataResult<List<CvLanguage>> findAllByCvId(int id);
}
