package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.model.JobSeeker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker, String confirmPassword) throws MalformedURLException {
        return ResponseEntity.ok(this.jobSeekerService.add(jobSeeker, confirmPassword));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@Valid @RequestParam int id) {
        return ResponseEntity.ok(this.jobSeekerService.deleteById(id));
    }

    @GetMapping("/getAll")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobSeekerService.getAll();
    }

    @GetMapping("/findByEmailAndPassword")
    public DataResult<JobSeeker> findByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return jobSeekerService.findByEmailAndPassword(email, password);
    }
}
