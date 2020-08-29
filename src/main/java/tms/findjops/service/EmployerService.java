package tms.findjops.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import tms.findjops.model.Administrator;
import tms.findjops.model.Applicant;
import tms.findjops.model.Employer;
import tms.findjops.model.Language;
import tms.findjops.repository.AdministratorRepository;
import tms.findjops.repository.ApplicantRepository;
import tms.findjops.repository.EmployerRepository;

@Service
@Data
public class EmployerService {

    private final AdministratorRepository administratorRepository;
    private final EmployerRepository employerRepository;
    private final ApplicantRepository applicantRepository;

    public void createEmployer(Employer employer){
        employerRepository.save(employer);
    }

    public Employer checkAuth (String email, String password){
        Employer byEmail = employerRepository.findByEmail(email);
        if (byEmail != null) {
            if (byEmail.getPassword().equals(password)) {
                return byEmail;
            }
        }
        return null;
    }

    public boolean checkEmployerReg (Employer employer){
        Applicant applicantCheck = applicantRepository.findByEmail(employer.getEmail());
        Employer employerCheck = employerRepository.findByEmail(employer.getEmail());
        Administrator administratorCheck = administratorRepository.findByEmail(employer.getEmail());
        return applicantCheck == null && employerCheck == null && administratorCheck == null;
    }


    public Language getLanguage (){
        return new Language();
    }
}
