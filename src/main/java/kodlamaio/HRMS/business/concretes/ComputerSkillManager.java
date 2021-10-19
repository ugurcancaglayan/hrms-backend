package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.ComputerSkillService;
import kodlamaio.HRMS.core.services.converter.DtoConverterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ComputerSkillDao;
import kodlamaio.HRMS.entities.concretes.CvComputerSkill;
import kodlamaio.HRMS.entities.dtos.CvComputerSkillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerSkillManager implements ComputerSkillService {

    private ComputerSkillDao computerSkillDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public ComputerSkillManager(ComputerSkillDao computerSkillDao, DtoConverterService dtoConverterService) {
        this.computerSkillDao = computerSkillDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result add(CvComputerSkillDto computerSkill) {
        this.computerSkillDao.save((CvComputerSkill) this.dtoConverterService.dtoClassConverter(computerSkill, CvComputerSkill.class));
        return new SuccessResult("Computer skill saved successfully.");
    }

    @Override
    public Result deleteById(int id) {
        this.computerSkillDao.deleteById(id);
        return new SuccessResult("Computer skill deleted successfully.");
    }

    @Override
    public DataResult<List<CvComputerSkill>> getAll() {
        return new SuccessDataResult<>(
                this.computerSkillDao.findAll(),
                "Computer skills listed successfully."
        );
    }
}
