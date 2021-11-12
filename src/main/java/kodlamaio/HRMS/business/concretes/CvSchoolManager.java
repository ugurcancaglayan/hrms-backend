package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.CvSchoolsService;
import kodlamaio.HRMS.core.services.converter.DtoConverterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CvSchoolsDao;
import kodlamaio.HRMS.entities.concretes.CvSchool;
import kodlamaio.HRMS.entities.dtos.CvSchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvSchoolManager implements CvSchoolsService {

    private CvSchoolsDao cvSchoolsDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public CvSchoolManager(CvSchoolsDao cvSchoolsDao, DtoConverterService dtoConverterService) {
        this.cvSchoolsDao = cvSchoolsDao;
        this.dtoConverterService = dtoConverterService;
    }

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
