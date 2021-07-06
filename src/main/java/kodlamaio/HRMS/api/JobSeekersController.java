package kodlamaio.HRMS.api;

import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.core.services.mernisService.MernisService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeeker jobSeeker, String confirmPassword) throws MalformedURLException {
        return this.jobSeekerService.add(jobSeeker, confirmPassword);
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobSeekerService.getAll();
    }
}
