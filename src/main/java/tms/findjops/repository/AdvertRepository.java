package tms.findjops.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import tms.findjops.model.Advert;
import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Long> {


    List <Advert> findAllByEmployerId (long id);
    Page<Advert> findAll (Pageable pageable);

}
