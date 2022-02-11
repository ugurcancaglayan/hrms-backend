package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.model.Employer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employers/")
@CrossOrigin
public class EmployerController {

    private final EmployerService employerService;

    @PostMapping(value = "add")
    public ResponseEntity<?> add(@Valid @RequestBody Employer employer) {
        return ResponseEntity.ok(this.employerService.add(employer));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestParam int id) {
        return ResponseEntity.ok(this.employerService.deleteById(id));
    }

    @GetMapping("getAll")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }

    @GetMapping("findByEmail")
    public DataResult<Employer> findByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return employerService.findByEmailAndPassword(email, password);
    }
}
