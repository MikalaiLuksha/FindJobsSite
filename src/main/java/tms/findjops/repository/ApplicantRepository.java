package tms.findjops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    Applicant findByEmail(String email);
}
