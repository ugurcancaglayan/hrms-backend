package kodlamaio.HRMS.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv_languages")
public class CvLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "level")
    private int level;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(targetEntity = CurriculumVitae.class)
    @JoinColumn(name = "cv_id")
    private CurriculumVitae curriculumVitae;
}
