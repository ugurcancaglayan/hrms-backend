package kodlamaio.HRMS.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.nvi.tckimlik.ws.KPSPublic;
import tr.gov.nvi.tckimlik.ws.KPSPublicSoap;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@RestController
@RequestMapping("/controller")
public class MernisController {

    @GetMapping("/check")
    public boolean check() throws MalformedURLException {
        String endpoint = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx";
        URL url = URI.create(endpoint).toURL();
        KPSPublic service = new KPSPublic(url);
        KPSPublicSoap port = service.getPort(KPSPublicSoap.class);
        return port.tcKimlikNoDogrula(19564835L, "Uğurcan", "Çağlayan", 2001);
    }
}
