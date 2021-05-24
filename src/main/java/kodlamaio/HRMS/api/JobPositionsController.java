package kodlamaio.HRMS.api;

import kodlamaio.HRMS.business.abstracts.JobPositionService;
import kodlamaio.HRMS.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    @Autowired
    private JobPositionService jobPositionService;

    @GetMapping("/getall")
    public List<JobPosition> getAll() {
        return jobPositionService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody JobPosition jobPosition) {
        jobPositionService.add(jobPosition);
    }
}
