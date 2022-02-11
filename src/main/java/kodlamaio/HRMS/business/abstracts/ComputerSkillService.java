package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.CvComputerSkill;
import kodlamaio.HRMS.dto.model.CvComputerSkillDto;

import java.util.List;

public interface ComputerSkillService {
    Result add(CvComputerSkillDto computerSkill);
    Result deleteById(int id);
    DataResult<List<CvComputerSkill>> getAll();
}
