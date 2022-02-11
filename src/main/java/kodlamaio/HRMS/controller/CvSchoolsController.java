package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.CvSchoolsService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.model.CvSchool;
import kodlamaio.HRMS.dto.model.CvSchoolDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cvSchools/")
@CrossOrigin
public class CvSchoolsController {

    private final CvSchoolsService cvService;

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
