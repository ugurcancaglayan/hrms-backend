package kodlamaio.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvJobExperienceDto {
    private int id;
    private String workplaceName;
    private Date entryDate;
    private Date exitDate;
    private boolean isContinue;
    private int jobPositionId;
    private int curriculumVitaeId;
}
