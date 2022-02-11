package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.ComputerSkillService;
import kodlamaio.HRMS.dto.mapper.DtoConverterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.repository.ComputerSkillDao;
import kodlamaio.HRMS.model.CvComputerSkill;
import kodlamaio.HRMS.dto.model.CvComputerSkillDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ComputerSkillManager implements ComputerSkillService {

    private final ComputerSkillDao computerSkillDao;
    private final DtoConverterService dtoConverterService;

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
