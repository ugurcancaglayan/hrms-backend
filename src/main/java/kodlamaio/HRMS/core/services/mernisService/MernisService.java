package kodlamaio.HRMS.core.services.mernisService;

import tr.gov.nvi.tckimlik.ws.KPSPublic;
import tr.gov.nvi.tckimlik.ws.KPSPublicSoap;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MernisService {
    public boolean validatePersonalInfo(long nationalId, String firstName, String lastName, int yearOfBirth) throws MalformedURLException {
        String endpoint = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx";
        URL url = URI.create(endpoint).toURL();
        KPSPublic service = new KPSPublic(url);
        KPSPublicSoap port = service.getPort(KPSPublicSoap.class);
        return port.tcKimlikNoDogrula(nationalId, firstName, lastName, yearOfBirth);
    }
}
