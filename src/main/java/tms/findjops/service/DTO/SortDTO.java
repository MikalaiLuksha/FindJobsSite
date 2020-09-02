package tms.findjops.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tms.findjops.model.Profession;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortDTO {

    private Profession profSort;

    private String sortSalary;


}
