package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.CurriculumVitaeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.CurriculumVitae;
import kodlamaio.HRMS.entities.dtos.CvDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cvs/")
@CrossOrigin
public class CurriculumVitaeController {

    private CurriculumVitaeService cvService;

    public CurriculumVitaeController(CurriculumVitaeService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody CvDto cvDto) {
        return ResponseEntity.ok(this.cvService.add(cvDto));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestParam int id) {
        return ResponseEntity.ok(this.cvService.deleteById(id));
    }

    @GetMapping("getAll")
    public DataResult<List<CurriculumVitae>> getAll() {
        return this.cvService.getAll();
    }

    @GetMapping("findAllByIsActive")
    public DataResult<List<CurriculumVitae>> findAllByIsActive() {
        return this.cvService.findAllByIsActive();
    }

}
