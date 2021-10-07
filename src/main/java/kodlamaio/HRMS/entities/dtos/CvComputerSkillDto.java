package kodlamaio.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvComputerSkillDto {
    private int id;
    private String skillName;
    private int curriculumVitaeId;
}
