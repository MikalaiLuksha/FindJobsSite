package tms.findjops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.UserFJ;

public interface UserRepository extends JpaRepository<UserFJ, Long> {

}
