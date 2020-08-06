package tms.findjops.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import tms.findjops.model.Employer;
import tms.findjops.repository.EmployerRepository;

@Service
@Data
public class EmployerService {

    private final EmployerRepository employerRepository;

    public void createEmployer(Employer employer){
        employerRepository.save(employer);
    }
}
