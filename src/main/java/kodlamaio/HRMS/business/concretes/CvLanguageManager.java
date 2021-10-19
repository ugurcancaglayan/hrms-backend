package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.CvLanguageService;
import kodlamaio.HRMS.core.services.converter.DtoConverterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CvLanguageDao;
import kodlamaio.HRMS.entities.concretes.CvLanguage;
import kodlamaio.HRMS.entities.dtos.CvLanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvLanguageManager implements CvLanguageService {

    private CvLanguageDao cvLanguageDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public CvLanguageManager(CvLanguageDao cvLanguageDao, DtoConverterService dtoConverterService) {
        this.cvLanguageDao = cvLanguageDao;
        this.dtoConverterService = dtoConverterService;
    }

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
