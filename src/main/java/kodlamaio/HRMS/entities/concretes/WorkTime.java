package kodlamaio.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="work_times")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class WorkTime {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="work_time")
    private String workTime;
}
