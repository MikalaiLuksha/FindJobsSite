package tms.findjops.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import tms.findjops.model.Advert;
import tms.findjops.model.Profession;
import tms.findjops.model.Status;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Long> {


    List <Advert> findAllByEmployerId (long id);

    Page<Advert> findAll (Pageable pageable);

    Page<Advert> findAllByStatus (Status status, Pageable pageable);

    Page<Advert> findAllByStatusAndProfession(Status status, Profession profession, Pageable pageable);

}
