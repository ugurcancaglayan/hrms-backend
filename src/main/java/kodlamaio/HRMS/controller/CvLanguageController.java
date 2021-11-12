package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.CvLanguageService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.CvLanguage;
import kodlamaio.HRMS.entities.dtos.CvLanguageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cvLanguage/")
@CrossOrigin
public class CvLanguageController {

    private CvLanguageService cvService;

    public CvLanguageController(CvLanguageService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody CvLanguageDto cvLanguage) {
        return ResponseEntity.ok(this.cvService.add(cvLanguage));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestParam int id) {
        return ResponseEntity.ok(this.cvService.deleteById(id));
    }

    @GetMapping("getAll")
    public DataResult<List<CvLanguage>> getAll() {
        return this.cvService.getAll();
    }

    @GetMapping("findAllByCvId")
    public DataResult<List<CvLanguage>> findAllByCvId(int id){
        return this.cvService.findAllByCvId(id);
    }

}
