package kodlamaio.HRMS.api;

import kodlamaio.HRMS.business.abstracts.VerificationCodeService;
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

    @Autowired
    public VerificationCodeController(VerificationCodeService verificationCodeService) {
        this.verificationCodeService = verificationCodeService;
    }

    @PostMapping("/update/{verificationCode}/{id}")
    public Result setVerify(@RequestParam String verificationCode,@RequestParam Integer id) {
        return verificationCodeService.verify(verificationCode, id);
    }

    @GetMapping("/getAll")
    public DataResult<List<VerificationCode>> getAll() {
        return this.verificationCodeService.getAll();
    }
}
