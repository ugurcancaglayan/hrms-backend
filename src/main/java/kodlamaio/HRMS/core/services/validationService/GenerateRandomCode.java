package kodlamaio.HRMS.core.services.validationService;

import java.util.UUID;

public class GenerateRandomCode {
    public String create() {
        UUID uuid = UUID.randomUUID();
        String verificationCode = uuid.toString();
        System.out.println("Your activation code:  " + verificationCode );
        return verificationCode;
    }
}
