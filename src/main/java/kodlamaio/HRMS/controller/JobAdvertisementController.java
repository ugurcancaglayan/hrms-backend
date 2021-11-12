package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements/")
@CrossOrigin
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

    @GetMapping("getById")
    public DataResult<JobAdvertisement> getById(@RequestParam int id) {
        return this.jobAdvertisementService.getById(id);
    }

    @GetMapping("getAllActive")
    public DataResult<List<JobAdvertisement>> findAllByIsActive( ) {
        return this.jobAdvertisementService.findAllByIsActive();
    }

    @GetMapping("getAllActiveSorted")
    public DataResult<List<JobAdvertisement>> findAllByIsActiveOrderByCreatedDateDesc() {
        return this.jobAdvertisementService.findAllByIsActiveOrderByCreatedDateDesc();
    }

    @GetMapping("getEmployersActiveJobAdvertisement")
    public DataResult<List<JobAdvertisement>> getEmployersActiveJobAdvertisement(@RequestParam int id) {
        return this.jobAdvertisementService.getEmployersActiveJobAdvertisement(id);
    }

    @GetMapping("setJobAdvertisementDisabled")
    public DataResult<JobAdvertisement> setJobAdvertisementDisabled(int id) {
        return this.jobAdvertisementService.setJobAdvertisementDisabled(id);
    }

    @GetMapping("filterJobs")
    public DataResult<List<JobAdvertisement>> filterJobs(@RequestParam int cityId, @RequestParam int workTimeId, @RequestParam int workTypeId) {
        return this.jobAdvertisementService.filterJobs(cityId, workTimeId, workTypeId);
    }

}
