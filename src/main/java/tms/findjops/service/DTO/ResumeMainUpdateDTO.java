package tms.findjops.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tms.findjops.model.Language;
import tms.findjops.model.Profession;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeMainUpdateDTO {

    private Profession profession;

    private int salary;

    private Language nativeLanguage;

    private List<Language> foreignLanguages;

    private String aboutMyself;

}
