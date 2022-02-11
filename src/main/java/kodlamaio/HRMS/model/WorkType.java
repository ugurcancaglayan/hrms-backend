package kodlamaio.HRMS.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="work_types")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class WorkType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="work_type")
    private String workType;
}
