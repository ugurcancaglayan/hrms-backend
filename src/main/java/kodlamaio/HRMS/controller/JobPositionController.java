package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.JobPositionService;
import kodlamaio.HRMS.core.services.mernisService.MernisService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.JobPosition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionController extends MernisService {

    private final JobPositionService jobPositionService;

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.add(jobPosition);
    }

    @DeleteMapping("/delete")
    public Result deleteById(@RequestParam int id) {
        return this.jobPositionService.deleteById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPosition>> getAll() {
        return this.jobPositionService.getAll();
    }

}
