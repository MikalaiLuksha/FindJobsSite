package tms.findjops.controller;

import lombok.Data;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tms.findjops.model.Advert;
import tms.findjops.model.Profession;
import tms.findjops.model.Status;
import tms.findjops.service.AdvertService;
import tms.findjops.service.DTO.SortDTO;
import tms.findjops.service.ResumeService;

import java.util.List;

@Data
@Controller
@RequestMapping("/")
public class IndexController {

    private final AdvertService advertService;
    private final ResumeService resumeService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String main(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        List<Profession> professions = resumeService.getAllProfession();
        model.addAttribute("profs", professions);
        Page<Advert> page = advertService.getAllByStatus(Status.checked, pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/");
        return "/index";
    }

    @RequestMapping(value = "sort", method = RequestMethod.POST)
    public String sortP(SortDTO sortDTO, Model model, Pageable pageable) {
        Page<Advert> page = advertService.getAllSort(sortDTO.getSortSalary(), Status.checked, sortDTO.getProfSort(), pageable);
        List<Profession> professions = resumeService.getAllProfession();
        model.addAttribute("profs", professions);
        model.addAttribute("page", page);
        model.addAttribute("url", "/");
        return "/index";
    }

    @RequestMapping(value = "error", method = RequestMethod.GET)
    public String sortP() {
        return "/index";
    }


}
