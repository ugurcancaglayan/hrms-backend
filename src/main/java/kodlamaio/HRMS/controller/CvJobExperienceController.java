package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.CvJobExperienceService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.CvJobExperince;
import kodlamaio.HRMS.entities.dtos.CvJobExperienceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cvJobExperince/")
@CrossOrigin
public class CvJobExperienceController {

    private CvJobExperienceService cvService;

    public CvJobExperienceController(CvJobExperienceService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody CvJobExperienceDto cvJobExperince) {
        return ResponseEntity.ok(this.cvService.add(cvJobExperince));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestParam int id) {
        return ResponseEntity.ok(this.cvService.deleteById(id));
    }

    @GetMapping("getAll")
    public DataResult<List<CvJobExperince>> getAll() {
        return this.cvService.getAll();
    }

}
