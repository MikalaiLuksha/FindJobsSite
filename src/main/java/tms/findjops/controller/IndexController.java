package tms.findjops.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tms.findjops.model.Advert;
import tms.findjops.model.Profession;
import tms.findjops.service.AdvertService;
import tms.findjops.service.ResumeService;

import java.util.List;

@Data
@Controller
@RequestMapping("/")
public class IndexController {

    private final AdvertService advertService;
    private final ResumeService resumeService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model){
        List<Profession> professions = resumeService.getAllProfession();
        model.addAttribute("profs", professions);
        List<Advert> all = advertService.getAll();
        model.addAttribute("allAdvert", all);
        return "index";
    }


}
