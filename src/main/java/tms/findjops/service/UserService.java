package tms.findjops.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import tms.findjops.model.User;
import tms.findjops.repository.UserRepository;

@Service
@Data
public class UserService {

    private final UserRepository userRepository;

    public void creatUser (User user){
        userRepository.save(user);
    }
}
