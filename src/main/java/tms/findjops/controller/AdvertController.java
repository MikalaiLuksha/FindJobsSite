package tms.findjops.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tms.findjops.model.Advert;
import tms.findjops.model.Employer;
import tms.findjops.model.Profession;
import tms.findjops.service.AdvertService;
import tms.findjops.service.ResumeService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Data
@Controller
@RequestMapping("/advert")
public class AdvertController {

    private final AdvertService advertService;
    private final ResumeService resumeService;

   @RequestMapping(value = "/addAdvert", method = RequestMethod.GET)
    public String addAdvertG(Model model){
       List<Profession> allProfession = resumeService.getAllProfession();
       model.addAttribute("professions", allProfession);
        return "/advert/addAdvert";
    }

    @RequestMapping(value = "/addAdvert", method = RequestMethod.POST)
    public String addAdvertP(Advert advert, HttpSession httpSession){
        Date date= new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        advert.setAddDate(calendar);
        Employer currentEmployer = (Employer) httpSession.getAttribute("currentEmployer");
        advert.setEmployer(currentEmployer);
        advertService.createAdvert(advert);
        return "redirect:/";
    }

    @RequestMapping(value = "/youAdvert", method = RequestMethod.GET)
    public String youAdvertG(HttpSession httpSession, Model model){
       Employer currentEmployer = (Employer) httpSession.getAttribute("currentEmployer");
        List<Advert> allAdvertById = advertService.getAllAdvertById(currentEmployer.getId());
        model.addAttribute("adverts", allAdvertById);
        return "/advert/youAdvert";
    }

    @RequestMapping(value = "/advert/{id}", method = RequestMethod.GET)
    public String advertG (Model model, @PathVariable(name = "id") long id, HttpSession httpSession){
        Advert advertById = advertService.getAdvertById(id);
        model.addAttribute("advert", advertById);
        Employer currentEmployer = (Employer) httpSession.getAttribute("currentEmployer");
        if (currentEmployer.getId()==advertById.getId()){
            model.addAttribute("checkEmp", "yes");
        }
        return "/advert/advert";
    }

    @RequestMapping(value = "/deleted/{id}", method = RequestMethod.POST)
    public String deletedP (@PathVariable(name = "id") long id){
       advertService.deleted(id);
        return "/advert/youAdvert";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateAdvertG(Model model, @PathVariable(name = "id") long id){
        List<Profession> allProfession = resumeService.getAllProfession();
        Advert advert = advertService.getAdvertById(id);
        model.addAttribute("advert", advert);
        model.addAttribute("professions", allProfession);
       return "/advert/advertUpdate";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateAdvertP(Advert advert, @PathVariable(name = "id") long id){
        advertService.updateAdvert(advert, id);
       return "redirect:/advert/advert/"+id;
    }
}
