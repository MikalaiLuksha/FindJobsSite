package tms.findjops.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import tms.findjops.model.Applicant;
import tms.findjops.repository.ApplicantRepository;

@Service
@Data
@AllArgsConstructor
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    public void createApplicant(Applicant applicant) {
        applicantRepository.save(applicant);
    }

    public Applicant checkAuth(String email, String password) {
        Applicant byEmail = applicantRepository.findByEmail(email);
        if (byEmail != null) {
            if (byEmail.getPassword().equals(password)) {
                return byEmail;
            }
        }
        return null;
    }

    public boolean checkReg(String email){
        Applicant applicant = applicantRepository.findByEmail(email);
        return applicant == null;
    }
}

