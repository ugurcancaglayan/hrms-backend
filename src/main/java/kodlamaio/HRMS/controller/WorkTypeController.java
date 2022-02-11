package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.WorkTypeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.WorkType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/worktypes/")
@CrossOrigin
public class WorkTypeController {

    private final WorkTypeService workTypeService;

    @PostMapping("/add")
    public Result add(@RequestBody WorkType workType) {
        return this.workTypeService.add(workType);
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkType>> getAll() {
        return this.workTypeService.getAll();
    }

}