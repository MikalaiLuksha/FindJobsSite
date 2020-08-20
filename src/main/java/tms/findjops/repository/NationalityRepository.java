package tms.findjops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.Nationality;

public interface NationalityRepository extends JpaRepository<Nationality, Long> {
}
