package tms.findjops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.PlaceOfWork;

public interface PlaceOfWorksRepository extends JpaRepository<PlaceOfWork, Long> {
}
