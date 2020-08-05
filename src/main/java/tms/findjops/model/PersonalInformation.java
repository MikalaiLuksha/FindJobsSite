package tms.findjops.model;

import java.util.Calendar;
import java.util.List;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
public class PersonalInformation {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Applicant userFJ;
    private String firstName;
    private String lastName;
    private Calendar birthday;

    private Gender gender;
    private String city;

//    @ManyToMany
    private List <Nationality> nationality;

}
