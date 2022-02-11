package kodlamaio.HRMS.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cv_job_experiences")
public class CvJobExperince {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "workplace_name")
    private String workplaceName;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "exit_date")
    private Date exitDate;

    @Column(name = "is_continue")
    private boolean isContinue;

    @ManyToOne
    //@JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CurriculumVitae curriculumVitae;
}
