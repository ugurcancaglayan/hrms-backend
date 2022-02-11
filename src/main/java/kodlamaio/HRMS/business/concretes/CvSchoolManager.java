package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.CvSchoolsService;
import kodlamaio.HRMS.dto.mapper.DtoConverterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.repository.CvSchoolsDao;
import kodlamaio.HRMS.model.CvSchool;
import kodlamaio.HRMS.dto.model.CvSchoolDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CvSchoolManager implements CvSchoolsService {

    private final CvSchoolsDao cvSchoolsDao;
    private final DtoConverterService dtoConverterService;

    @Override
    public Result add(CvSchoolDto cvSchool) {
        this.cvSchoolsDao.save((CvSchool) dtoConverterService.dtoClassConverter(cvSchool, CvSchool.class));
        return new SuccessResult("School saved successfullyç");
    }

    @Override
    public Result deleteById(int id) {
        this.cvSchoolsDao.deleteById(id);
        return new SuccessResult("School deleted successfullyç");
    }

    @Override
    public DataResult<List<CvSchool>> getAll() {
        return new SuccessDataResult<List<CvSchool>>(
                this.cvSchoolsDao.findAll(),
                "Schools listed successfully."
        );
    }
}
