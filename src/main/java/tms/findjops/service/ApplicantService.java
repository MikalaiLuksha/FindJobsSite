package tms.findjops.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.stereotype.Service;
import tms.findjops.model.*;
import tms.findjops.repository.*;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class ApplicantService {

    private final AdministratorRepository administratorRepository;
    private final EmployerRepository employerRepository;
    private final ApplicantRepository applicantRepository;
    private final NationalityRepository nationalityRepository;
    private final LanguageRepository languageRepository;
    private final ProfessionRepository professionRepository;

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

    public boolean checkApplicantReg (Applicant applicant){
        Applicant applicantCheck = applicantRepository.findByEmail(applicant.getEmail());
        Employer employerCheck = employerRepository.findByEmail(applicant.getEmail());
        Administrator administratorCheck = administratorRepository.findByEmail(applicant.getEmail());
        return applicantCheck == null && employerCheck == null && administratorCheck == null;
    }
    
    public Applicant getApplicant(){
        return new Applicant();
    }

    public List<Nationality> getAllNationality(){
        return nationalityRepository.findAll();
    }


}

