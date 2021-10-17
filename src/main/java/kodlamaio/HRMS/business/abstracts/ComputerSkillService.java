package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.CvComputerSkill;
import kodlamaio.HRMS.entities.dtos.CvComputerSkillDto;

import java.util.List;

public interface ComputerSkillService {
    Result add(CvComputerSkillDto computerSkill);
    Result deleteById(int id);
    DataResult<List<CvComputerSkill>> getAll();
}
