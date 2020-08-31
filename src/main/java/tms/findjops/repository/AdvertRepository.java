package tms.findjops.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.Advert;
import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Long> {


    List <Advert> findAllByEmployerId (long id);

}
