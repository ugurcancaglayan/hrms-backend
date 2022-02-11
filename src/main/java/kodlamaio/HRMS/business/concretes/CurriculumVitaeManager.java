package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.CurriculumVitaeService;
import kodlamaio.HRMS.dto.mapper.DtoConverterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.repository.CurriculumVitaeDao;
import kodlamaio.HRMS.model.CurriculumVitae;
import kodlamaio.HRMS.dto.model.CvDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private final CurriculumVitaeDao curriculumVitaeDAO;
    private final DtoConverterService dtoConverterService;

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
