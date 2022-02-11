package kodlamaio.HRMS.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvSchoolDto {
    private int id;
    private String schoolName;
    private Date entryDate;
    private Date graduationDate;
    private boolean isContinue;
    private String departmant;
    private int curriculumVitaeId;
}
