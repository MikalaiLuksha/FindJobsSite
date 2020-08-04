package tms.findjops.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import tms.findjops.model.UserFJ;
import tms.findjops.repository.UserRepository;

@Service
@Data
public class UserService {

    private final UserRepository userRepository;

    public void creatUser (UserFJ user){
        userRepository.save(user);
    }
}
