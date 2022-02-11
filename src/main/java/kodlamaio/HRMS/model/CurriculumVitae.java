package kodlamaio.HRMS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "curriculum_vitaes")
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "github_adress")
    private String githubAdress;

    @Column(name = "linkedin_adress")
    private String linkedinAdress;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "photo")
    private String photo;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<CvComputerSkill> cvComputerSkills;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<CvJobExperince> cvJobExperinces;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<CvLanguage> cvLanguages;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<CvSchool> educations;
}
