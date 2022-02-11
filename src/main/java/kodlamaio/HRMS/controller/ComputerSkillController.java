package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.ComputerSkillService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.model.CvComputerSkill;
import kodlamaio.HRMS.dto.model.CvComputerSkillDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/computerSkill/")
@CrossOrigin
public class ComputerSkillController {

    private final ComputerSkillService cvService;

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody CvComputerSkillDto computerSkill) {
        return ResponseEntity.ok(this.cvService.add(computerSkill));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestParam int id) {
        return ResponseEntity.ok(this.cvService.deleteById(id));
    }

    @GetMapping("getAll")
    public DataResult<List<CvComputerSkill>> getAll() {
        return this.cvService.getAll();
    }

}
