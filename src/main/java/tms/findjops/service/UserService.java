package tms.findjops.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import tms.findjops.model.Applicant;
import tms.findjops.repository.UserRepository;

@Service
@Data
public class UserService {

    private final UserRepository userRepository;

    public void creatUser (Applicant user){
        userRepository.save(user);
    }
}
