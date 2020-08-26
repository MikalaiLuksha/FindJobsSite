package tms.findjops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
