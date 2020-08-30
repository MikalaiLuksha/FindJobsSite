package tms.findjops.service;

import org.springframework.stereotype.Service;
import tms.findjops.model.Advert;

import java.util.Comparator;

@Service
public class ComparatorAdvert implements Comparator <Advert> {


    @Override
    public int compare(Advert o1, Advert o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }

    public int reverse (Advert o1, Advert o2) {
        return Integer.compare(o2.getSalary(), o1.getSalary());
    }


}
