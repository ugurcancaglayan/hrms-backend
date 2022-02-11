package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.VerificationCodeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.model.VerificationCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/verificationCodes/")
@CrossOrigin
public class VerificationCodeController {

    private final VerificationCodeService verificationCodeService;

    @PostMapping("update/{verificationCode}/{id}")
    public Result setVerify(@RequestParam String verificationCode,@RequestParam Integer id) {
        return verificationCodeService.verify(verificationCode, id);
    }

    @GetMapping("getAll")
    public DataResult<List<VerificationCode>> getAll() {
        return this.verificationCodeService.getAll();
    }

}
