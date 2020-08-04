package tms.findjops.model;

import java.util.Calendar;
import java.util.List;

public class PersonalInformation {

    private long id;
    private UserFJ userFJ;
    private String firstName;
    private String lastName;
    private Calendar birthday;
    private Gender gender;
    private String city;
    private List <Nationality> nationality;

}
