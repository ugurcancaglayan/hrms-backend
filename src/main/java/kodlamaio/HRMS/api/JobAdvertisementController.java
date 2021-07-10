package kodlamaio.HRMS.api;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements/")
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("getAllActive")
    public DataResult<List<JobAdvertisement>> findAllByIsActive(boolean isActive) {
        return this.jobAdvertisementService.findAllByIsActive(isActive);
    }

    @GetMapping("getAllActiveSorted")
    public DataResult<List<JobAdvertisement>> findAllByIsActiveOrderByCreatedDateDesc(boolean isActive) {
        return this.jobAdvertisementService.findAllByIsActiveOrderByCreatedDateDesc(isActive);
    }

}
