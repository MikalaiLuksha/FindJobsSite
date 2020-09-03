package tms.findjops.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    Applicant findByEmail(String email);

    @Override
    Page<Applicant> findAll(Pageable pageable);
}
