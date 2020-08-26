package tms.findjops.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Employer employer;

    @OneToOne(fetch = FetchType.EAGER)
    private Profession profession;

    @Column(name = "salary")
    private int salary;

    @Column(name = "responsibility")
    private String responsibility;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "terms")
    private String terms;

    @Column(name = "add_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Calendar addDate;
}
