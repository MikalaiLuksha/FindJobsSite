package tms.findjops.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import tms.findjops.model.Employer;
import tms.findjops.model.Language;
import tms.findjops.repository.EmployerRepository;

@Service
@Data
public class EmployerService {

    private final EmployerRepository employerRepository;

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

    public boolean checkReg(String email){
        Employer employer = employerRepository.findByEmail(email);
        if (employer == null){
            return true;
        }
        return false;
    }

    public Language getLanguage (){
        return new Language();
    }
}
