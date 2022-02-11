package kodlamaio.HRMS.core.services.imageService;

import java.io.IOException;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    DataResult<?> uploadPhoto(MultipartFile file) throws IOException;
}
