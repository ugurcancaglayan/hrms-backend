package kodlamaio.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv_schools")
public class CvSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "graduation_date")
    private Date graduationDate;

    @Column(name = "is_continue")
    private boolean isContinue;

    @Column(name = "departmant")
    private String departmant;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(targetEntity = CurriculumVitae.class)
    @JoinColumn(name = "cv_id")
    private CurriculumVitae curriculumVitae;
}
