package tms.findjops.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Applicant applicant;

    @OneToOne(fetch = FetchType.EAGER)
    private Profession profession;

    @Column(name = "salary")
    private int salary;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<PlaceOfWork> placeOfWorks;

    @Column(name = "about_myself")
    private String aboutMyself;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Education> educations;

    @OneToOne(fetch = FetchType.EAGER)
    private Language nativeLanguage;

    @Column(name = "work_experience")
    private String workExperience;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Language> foreignLanguages;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
