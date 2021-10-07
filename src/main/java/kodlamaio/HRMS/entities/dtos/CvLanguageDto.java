package kodlamaio.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvLanguageDto {
    private int id;
    private String languageName;
    private int level;
    private int curriculumVitaeId;
}
