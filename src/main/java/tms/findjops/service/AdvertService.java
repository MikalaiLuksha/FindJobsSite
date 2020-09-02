package tms.findjops.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tms.findjops.model.Advert;
import tms.findjops.model.Profession;
import tms.findjops.model.Status;
import tms.findjops.repository.AdvertRepository;
import tms.findjops.service.DTO.SortDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class AdvertService {

    private final AdvertRepository advertRepository;
    private final ComparatorAdvert comparatorAdvert;

    public void createAdvert(Advert advert) {
        advert.setStatus(Status.unchecked);
        advertRepository.save(advert);
    }

    public List<Advert> getAllAdvertById(long id) {
        return advertRepository.findAllByEmployerId(id);
    }

    public Page<Advert> getAllByStatus(Status status, Pageable pageable) {
        return advertRepository.findAllByStatus(status, pageable);
    }

    public Page<Advert> getAll(Pageable pageable) {
        return advertRepository.findAll(pageable);
    }


    public Page<Advert> getAllSort(String sortSalary, Status status, Profession profession, Pageable pageable) {
        if (sortSalary.equals("salary increase")) {
            Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("salary").ascending());
            return advertRepository.findAllByStatusAndProfession(status, profession, pageable1);
        }
        if (sortSalary.equals("salary decrease")) {
            Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("salary").descending());
            return advertRepository.findAllByStatusAndProfession(status, profession, pageable1);
        }
        if (sortSalary.equals("no")) {
            Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").ascending());
            return advertRepository.findAllByStatusAndProfession(status, profession, pageable1);
        }
        return null;
    }

    public Advert getAdvertById(long id) {
        return advertRepository.getOne(id);
    }

    public void deleted(long id) {
        advertRepository.deleteById(id);
    }

//    public List<Advert> getSortAdvert(SortDTO sortDTO) {
//        List<Advert> allAdvert = advertRepository.findAll();
//        List<Advert> adverts = sortProf(sortDTO, allAdvert);
//        List<Advert> adverts1 = sortSalaryPeriod(sortDTO, adverts);
//        return compareSalary(sortDTO, adverts1);
//    }
//
//    private List<Advert> sortProf(SortDTO sortDTO, List<Advert> allAdvert) {
//        List<Advert> sortProf = new ArrayList<>();
//        if (sortDTO.getProfSort() == null){
//            return allAdvert;
//        }
//        else {
//            for (Advert adv : allAdvert) {
//                for (Profession prof : sortDTO.getProfSort()) {
//                    if (adv.getProfession().getName().equals(prof.getName())) {
//                        sortProf.add(adv);
//                    }
//                }
//            }
//            return sortProf;
//        }
//    }
//
//    private List<Advert> sortSalaryPeriod(SortDTO sortDTO, List<Advert> advertList) {
//        List<Advert> sortSalaryPeriod = new ArrayList<>();
//        if (sortDTO.getSalaryPeriod() == null){
//            return advertList;
//        }
//        else {
//            switch (sortDTO.getSalaryPeriod()) {
//                case ("less 1000"):
//                    for (Advert adv : advertList) {
//                        if (adv.getSalary() < 1000) {
//                            sortSalaryPeriod.add(adv);
//                        }
//                    }
//                    break;
//                case ("1000 - 1500"):
//                    for (Advert adv : advertList) {
//                        if (adv.getSalary() >= 1000 && adv.getSalary() < 1500) {
//                            sortSalaryPeriod.add(adv);
//                        }
//                    }
//                    break;
//                case ("1500 - 2000"):
//                    for (Advert adv : advertList) {
//                        if (adv.getSalary() >= 1500 && adv.getSalary() < 2000) {
//                            sortSalaryPeriod.add(adv);
//                        }
//                    }
//                    break;
//                case ("more 2000"):
//                    for (Advert adv : advertList) {
//                        if (adv.getSalary() >= 2000) {
//                            sortSalaryPeriod.add(adv);
//                        }
//                    }
//                    break;
//            }
//            return sortSalaryPeriod;
//        }
//    }
//
//    private List<Advert> compareSalary (SortDTO sortDTO, List<Advert> advertList){
//        switch (sortDTO.getSalarySort()){
//            case "salary increase":
//                advertList.sort(comparatorAdvert);
//                return advertList;
//            case "salary decrease":
//                advertList.sort(comparatorAdvert::reverse);
//                return advertList;
//            case "no":
//                return advertList;
//            default:
//                return null;
//        }
//    }

    public void updateAdvert(Advert advert, long id) {
        Advert one = advertRepository.getOne(id);
        one.setProfession(advert.getProfession());
        one.setRequirements(advert.getRequirements());
        one.setResponsibility(advert.getResponsibility());
        one.setSalary(advert.getSalary());
        one.setTerms(advert.getTerms());
        advertRepository.save(one);
    }

    public Advert updateStatus(Status status, long id) {
        Advert one = advertRepository.getOne(id);
        one.setStatus(status);
        advertRepository.save(one);
        return one;
    }
}
