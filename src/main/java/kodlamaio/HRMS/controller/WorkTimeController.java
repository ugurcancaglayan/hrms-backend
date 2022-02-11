package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.WorkTimeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.WorkTime;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/worktimes/")
@CrossOrigin
public class WorkTimeController {

    private final WorkTimeService workTimeService;

    @PostMapping("/add")
    public Result add(@RequestBody WorkTime workTime) {
        return this.workTimeService.add(workTime);
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkTime>> getAll() {
        return this.workTimeService.getAll();
    }

}