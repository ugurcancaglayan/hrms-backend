package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.CvSchoolsService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.CvSchool;
import kodlamaio.HRMS.entities.dtos.CvSchoolDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cvSchools/")
public class CvSchoolsController {

    private CvSchoolsService cvService;

    public CvSchoolsController(CvSchoolsService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody CvSchoolDto cvSchool) {
        return ResponseEntity.ok(this.cvService.add(cvSchool));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestParam int id) {
        return ResponseEntity.ok(this.cvService.deleteById(id));
    }

    @GetMapping("getAll")
    public DataResult<List<CvSchool>> getAll() {
        return this.cvService.getAll();
    }

}
