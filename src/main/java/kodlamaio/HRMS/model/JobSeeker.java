package kodlamaio.HRMS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "job_seekers")
public class JobSeeker extends User {

    @Column(unique = true, name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_identity")
    private long nationalId;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

}
