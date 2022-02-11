package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.JobSeeker;

import java.net.MalformedURLException;
import java.util.List;

public interface JobSeekerService {
    Result add(JobSeeker jobSeeker, String confirmPassword) throws MalformedURLException;
    Result deleteById(int id);
    DataResult<List<JobSeeker>> getAll();
    DataResult<JobSeeker> findByEmailAndPassword(String email, String password);
}
