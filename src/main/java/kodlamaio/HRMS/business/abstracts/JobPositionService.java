package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.dataAccess.abstracts.JobPositionDao;
import kodlamaio.HRMS.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {

    List<JobPosition> getAll();

    void add(JobPosition jobPosition);
}
