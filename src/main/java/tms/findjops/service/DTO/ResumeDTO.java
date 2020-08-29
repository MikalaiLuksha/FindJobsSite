package tms.findjops.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tms.findjops.model.*;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDTO {

    private Applicant applicant;

    private Profession profession;

    private int salary;

    private String workExperience;

    private String aboutMyself;

    private String educationLevel;

    private Language nativeLanguage;

    private List<Language> foreignLanguages;
}
