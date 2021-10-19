package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.CurriculumVitaeService;
import kodlamaio.HRMS.core.services.converter.DtoConverterManager;
import kodlamaio.HRMS.core.services.converter.DtoConverterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.HRMS.entities.concretes.CurriculumVitae;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import kodlamaio.HRMS.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private CurriculumVitaeDao curriculumVitaeDAO;
    private DtoConverterService dtoConverterService;

    @Autowired
    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDAO, DtoConverterService dtoConverterService) {
        this.curriculumVitaeDAO = curriculumVitaeDAO;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result add(CvDto cvDto) {
        this.curriculumVitaeDAO.save((CurriculumVitae) this.dtoConverterService.dtoClassConverter(cvDto, CurriculumVitae.class));
        return new SuccessResult("CV saved successfully.");
    }

    @Override
    public Result deleteById(int id) {
        this.curriculumVitaeDAO.deleteById(id);
        return new SuccessResult("CV deleted successfully.");
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<>(
                this.curriculumVitaeDAO.findAll(),
                "CV's listed successfully."
        );
    }

    @Override
    public DataResult<List<CurriculumVitae>> findAllByIsActive() {
        return new SuccessDataResult<List<CurriculumVitae>>(
                this.curriculumVitaeDAO.findAllByIsActive(true),
                "Active CV's are listed.");
    }
}
