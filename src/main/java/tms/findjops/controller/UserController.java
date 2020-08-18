package tms.findjops.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tms.findjops.model.Applicant;
import tms.findjops.model.Employer;
import tms.findjops.service.ApplicantService;
import tms.findjops.service.EmployerService;
import tms.findjops.service.UserDTO;

import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/reg/applicant", method = RequestMethod.POST)
    public String regApplP(Applicant applicant, HttpSession httpSession, Model model){
        if (applicantService.checkReg(applicant.getEmail())||employerService.checkReg(applicant.getEmail())){
        applicantService.createApplicant(applicant);
        httpSession.setAttribute("message", "Completed applicant registration");
            return ("redirect:/");
        }
        else{model.addAttribute("messageError", "Email already used");
            return "/reg/applicant";
        }
    }

    @RequestMapping(value = "/reg/employer", method = RequestMethod.POST)
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
            httpSession.setAttribute("checkReg", true);
            return ("redirect:/");
        }
        if (employer != null){
            httpSession.setAttribute("currentEmployer", employer);
            httpSession.setAttribute("message", "Completed employer auth");
            httpSession.setAttribute("checkRegE", true);
            httpSession.setAttribute("checkReg", true);
            return ("redirect:/");
        }
        if (applicant == null && employer == null){
            httpSession.setAttribute("message", "Email or password incorrect");
            return "/auth";
        }
        return "/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutG(HttpSession httpSession){
        httpSession.removeAttribute("currentApplicant");
        httpSession.removeAttribute("currentEmployer");
        httpSession.removeAttribute("message");
        httpSession.removeAttribute("checkRegE");
        httpSession.removeAttribute("checkReg");
        httpSession.removeAttribute("checkRegA");
        return "/";
    }


}
