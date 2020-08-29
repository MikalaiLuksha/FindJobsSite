package tms.findjops.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import tms.findjops.model.Administrator;
import tms.findjops.repository.AdministratorRepository;

@Data
@Service
@AllArgsConstructor
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    public Administrator checkAuth(String email, String password) {
        Administrator byEmail = administratorRepository.findByEmail(email);
        if (byEmail != null) {
            if (byEmail.getPassword().equals(password)) {
                return byEmail;
            }
        }
        return null;
    }


}
