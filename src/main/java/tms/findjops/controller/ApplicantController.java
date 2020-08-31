package tms.findjops.controller;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tms.findjops.model.Applicant;
import tms.findjops.model.Gender;
import tms.findjops.model.Nationality;
import tms.findjops.service.ApplicantService;


import javax.servlet.http.HttpSession;
import java.util.List;

@Data
@Controller
@RequestMapping("/user/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String regApplP(Applicant applicant, HttpSession httpSession, Model model){
        if (applicantService.checkApplicantReg(applicant)){
            httpSession.setAttribute("applicantPre", applicant);
            return ("redirect:/user/applicant/addProfile");
        }
        else {model.addAttribute("messageError", "Email already used");
            return "/reg";
        }
    }

    @RequestMapping(value = "/addProfile", method = RequestMethod.GET)
    public String addProfileG (Model model){
        List<Nationality> allNationality = applicantService.getAllNationality();
        model.addAttribute("genders", Gender.values());
        model.addAttribute("nationality", allNationality);
        return "/applicant/addProfile";
    }

    @RequestMapping(value = "/addProfile", method = RequestMethod.POST)
    public String addProfileP (Applicant applicant, HttpSession httpSession, Model model){
        Applicant applicantPre = (Applicant) httpSession.getAttribute("applicantPre");
        applicantPre.setBirthday(applicant.getBirthday());
        applicantPre.setGender(applicant.getGender());
        applicantPre.setNationality(applicant.getNationality());
        applicantPre.setTelephone(applicant.getTelephone());
        applicantService.createApplicant(applicantPre);
        httpSession.setAttribute("message", "Completed applicant registration");
        return "redirect:/";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String accountG (){
        return "/applicant/account";
    }

    @RequestMapping(value = "/account/update", method = RequestMethod.GET)
    public String updateAccountG (Model model){
        List<Nationality> allNationality = applicantService.getAllNationality();
        model.addAttribute("genders", Gender.values());
        model.addAttribute("nationality", allNationality);
        return "/applicant/updateAccount";
    }

    @RequestMapping(value = "/account/update", method = RequestMethod.POST)
    public String updateAccountP (Applicant applicant, HttpSession httpSession){
        Applicant currentApplicant = (Applicant) httpSession.getAttribute("currentApplicant");
        Applicant applicant1 = applicantService.updateApplicant(applicant, currentApplicant.getId());
        httpSession.setAttribute("currentApplicant", applicant1);
        return "/applicant/account";
    }

}
