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
public class PlaceOfWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "beginning_of_work")
    private String beginningOfWork;

    @Column(name = "end_of_work")
    private String endOfWork;

    @Column(name = "organization")
    private String organization;

    @Column(name = "position_")
    private String position;

    @Column(name = "workplace_responsibilities")
    private String workplaceResponsibilities;
}
