package tms.findjops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.Applicant;

public interface UserRepository extends JpaRepository<Applicant, Long> {

}
