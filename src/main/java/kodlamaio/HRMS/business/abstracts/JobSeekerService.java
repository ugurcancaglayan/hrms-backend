package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.List;

@Service
public interface JobSeekerService {
    Result add(JobSeeker jobSeeker, String confirmPassword) throws MalformedURLException;
    DataResult<List<JobSeeker>> getAll();
}
