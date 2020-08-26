package tms.findjops.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.stereotype.Service;
import tms.findjops.model.*;
import tms.findjops.repository.ApplicantRepository;
import tms.findjops.repository.LanguageRepository;
import tms.findjops.repository.NationalityRepository;
import tms.findjops.repository.ProfessionRepository;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final NationalityRepository nationalityRepository;
    private final LanguageRepository languageRepository;
    private final ProfessionRepository professionRepository;
//    private final ModelMapper modelMapper;

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
    
    public Applicant getApplicant(){
        return new Applicant();
    }

    public List<Nationality> getAllNationality(){
        return nationalityRepository.findAll();
    }


}

