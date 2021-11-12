package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.WorkTypeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worktypes/")
@CrossOrigin
public class WorkTypeController {

    private WorkTypeService workTypeService;

    @Autowired
    public WorkTypeController(WorkTypeService workTypeService) {
        this.workTypeService = workTypeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody WorkType workType) {
        return this.workTypeService.add(workType);
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkType>> getAll() {
        return this.workTypeService.getAll();
    }

}