package tms.findjops.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
