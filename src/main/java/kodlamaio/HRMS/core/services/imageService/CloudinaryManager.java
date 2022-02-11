package kodlamaio.HRMS.core.services.imageService;

import com.cloudinary.utils.ObjectUtils;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryManager implements CloudinaryService{


    @Override
    public DataResult<?> uploadPhoto(MultipartFile multipartFile) throws IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dohpebn0j",
                "api_key", "764825444399197",
                "api_secret", "SJfXfzIJ5HOodEDSKAL_cyks4H8",
                "secure", true));

        try{
            Map cloudinaryUploader = cloudinary.uploader()
                    .upload(multipartFile.getBytes()
                            ,ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(cloudinaryUploader);
        }

        catch (IOException e){
            e.printStackTrace();
        }
        return new ErrorDataResult<Map>();
    }
}