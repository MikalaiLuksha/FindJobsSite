package tms.findjops.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import tms.findjops.model.Advert;
import tms.findjops.repository.AdvertRepository;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class AdvertService {

    private final AdvertRepository advertRepository;

    public void createAdvert(Advert advert){
        advertRepository.save(advert);
        }

        public List<Advert>
}
