package kodlamaio.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
    private int id;
    private int jobSeekerId;
    private String linkedinAdress;
    private String githubAdress;
    private String coverLetter;
    private boolean isActive;
    private String photo;
}
