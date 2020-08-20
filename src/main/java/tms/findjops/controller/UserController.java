package tms.findjops.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tms.findjops.model.Applicant;
import tms.findjops.model.Employer;
import tms.findjops.model.Gender;
import tms.findjops.model.Nationality;
import tms.findjops.service.ApplicantService;
import tms.findjops.service.EmployerService;
import tms.findjops.service.UserDTO;

import javax.servlet.http.HttpSession;
import java.util.List;

@Data
@Controller
@RequestMapping("/user")
public class UserController {

    private final ApplicantService applicantService;
    private final EmployerService employerService;
    private final UserDTO userDTO;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String regUserG(){
        return "reg";
    }

    @RequestMapping(value = "/applicant/reg", method = RequestMethod.POST)
    public String regApplP(Applicant applicant, HttpSession httpSession, Model model){
        if (applicantService.checkReg(applicant.getEmail())||employerService.checkReg(applicant.getEmail())){
        httpSession.setAttribute("applicantPre", applicant);
            return ("redirect:/user/applicant/addProfile");
        }
        else{model.addAttribute("messageError", "Email already used");
            return "/reg/applicant";
        }
    }

    @RequestMapping(value = "/applicant/addProfile", method = RequestMethod.GET)
    public String addProfileG (Model model){
        List<Nationality> allNationality = applicantService.getAllNationality();
        model.addAttribute("genders", Gender.values());
        model.addAttribute("nationality", allNationality);
        return "/applicant/addprofile";
    }

    @RequestMapping(value = "/applicant/addProfile", method = RequestMethod.POST)
    public String addProfileP (Applicant applicant, HttpSession httpSession, Model model){
        Applicant applicantPre = (Applicant) httpSession.getAttribute("applicantPre");
        applicantPre.setBirthday(applicant.getBirthday());
        applicantPre.setGender(applicant.getGender());
        applicantPre.setNationality(applicant.getNationality());
        applicantPre.setTelephone(applicant.getTelephone());
        applicantService.createApplicant(applicantPre);
        httpSession.setAttribute("message", "Completed applicant registration");
        return "/";
    }


    @RequestMapping(value = "/employer/reg", method = RequestMethod.POST)
    public String regEmpP(Employer employer, HttpSession httpSession){
        if (applicantService.checkReg(employer.getEmail())||employerService.checkReg(employer.getEmail())){
        employerService.createEmployer(employer);
        httpSession.setAttribute("message", "Completed employer registration");
            return ("redirect:/");
        }
        else{httpSession.setAttribute("message", "Email already used");
            return ("redirect:/reg/applicant");
        }
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String authUserG(){
        return "auth";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String authUserP(UserDTO userDTO, HttpSession httpSession){
        Applicant applicant = applicantService.checkAuth(userDTO.getEmail(), userDTO.getPassword());
        Employer employer = employerService.checkAuth(userDTO.getEmail(), userDTO.getPassword());
        if (applicant != null){
            httpSession.setAttribute("currentApplicant", applicant);
            httpSession.setAttribute("message", "Completed applicant auth");
            httpSession.setAttribute("checkRegA", true);
            httpSession.setAttribute("checkReg", false);
            return ("redirect:/");
        }
        if (employer != null){
            httpSession.setAttribute("currentEmployer", employer);
            httpSession.setAttribute("message", "Completed employer auth");
            httpSession.setAttribute("checkRegE", true);
            httpSession.setAttribute("checkReg", false);
            return ("redirect:/");
        }
        if (applicant == null && employer == null){
            httpSession.setAttribute("message", "Email or password incorrect");
            return "/auth";
        }
        return "/";
    }

    @RequestMapping(value = "/applicant/account", method = RequestMethod.GET)
    public String accountG (){
        return "/applicant/account";
    }






    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutG(HttpSession httpSession){
        httpSession.removeAttribute("currentApplicant");
        httpSession.removeAttribute("currentEmployer");
        httpSession.removeAttribute("message");
        httpSession.removeAttribute("checkRegE");
        httpSession.removeAttribute("checkReg");
        httpSession.removeAttribute("checkRegA");
        return ("redirect:/");
    }


}
