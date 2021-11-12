package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.WorkTimeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worktimes/")
@CrossOrigin
public class WorkTimeController {

    private WorkTimeService workTimeService;

    @Autowired
    public WorkTimeController(WorkTimeService workTimeService) {
        this.workTimeService = workTimeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody WorkTime workTime) {
        return this.workTimeService.add(workTime);
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkTime>> getAll() {
        return this.workTimeService.getAll();
    }

}