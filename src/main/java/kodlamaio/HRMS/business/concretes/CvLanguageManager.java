package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.CvLanguageService;
import kodlamaio.HRMS.dto.mapper.DtoConverterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.repository.CvLanguageDao;
import kodlamaio.HRMS.model.CvLanguage;
import kodlamaio.HRMS.dto.model.CvLanguageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CvLanguageManager implements CvLanguageService {

    private final CvLanguageDao cvLanguageDao;
    private final DtoConverterService dtoConverterService;

    @Override
    public Result add(CvLanguageDto cvLanguage) {
        this.cvLanguageDao.save((CvLanguage) dtoConverterService.dtoClassConverter(cvLanguage, CvLanguage.class));
        return new SuccessResult("Language saved successfully.");
    }

    @Override
    public Result deleteById(int id) {
        this.cvLanguageDao.deleteById(id);
        return new SuccessResult("Language deleted successfully.");
    }

    @Override
    public DataResult<List<CvLanguage>> getAll() {
        return new SuccessDataResult<List<CvLanguage>>(
                this.cvLanguageDao.findAll(),
                "Languages listed successfully."
        );
    }

    @Override
    public DataResult<List<CvLanguage>> findAllByCvId(int id) {
        return new SuccessDataResult<List<CvLanguage>>(
                this.cvLanguageDao.findAllByCurriculumVitae_Id(id),
                "Language listed successfully.");
    }
}
