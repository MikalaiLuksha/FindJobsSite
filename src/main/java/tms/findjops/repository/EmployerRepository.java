package tms.findjops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
