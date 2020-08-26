package tms.findjops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.Advert;

public interface AdvertRepository extends JpaRepository<Advert, Long> {
}
