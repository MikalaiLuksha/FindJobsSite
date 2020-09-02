package tms.findjops.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tms.findjops.model.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortAdvertListAdminDTO {

    @Enumerated(EnumType.STRING)
    private Status status;
}
