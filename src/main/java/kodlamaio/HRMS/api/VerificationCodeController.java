package kodlamaio.HRMS.api;

import kodlamaio.HRMS.business.abstracts.VerificationCodeService;
import kodlamaio.HRMS.core.services.validationService.ValidationService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/verificationCodes")
public class VerificationCodeController {

    private VerificationCodeService verificationCodeService;
    private ValidationService validationService;

    @Autowired
    public VerificationCodeController(VerificationCodeService verificationCodeService, ValidationService validationService) {
        this.verificationCodeService = verificationCodeService;
        this.validationService = validationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody VerificationCode verificationCode) {
        return this.verificationCodeService.add(verificationCode);
    }

    @PostMapping("/update/{verificationCode}/{id}")
    public Result setVerify(@RequestParam String verificationCode,@RequestParam Integer id) {
        return validationService.verify(verificationCode, id);
    }

    @GetMapping("/getall")
    public DataResult<List<VerificationCode>> getAll() {
        return this.verificationCodeService.getAll();
    }
}
