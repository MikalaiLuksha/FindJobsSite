package tms.findjops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
