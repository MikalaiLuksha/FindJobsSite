package tms.findjops.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import tms.findjops.model.Applicant;
import tms.findjops.repository.ApplicantRepository;

@Service
@Data
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    public void createApplicant (Applicant applicant){
        applicantRepository.save(applicant);
    }
}

