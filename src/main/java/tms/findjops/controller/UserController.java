package tms.findjops.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tms.findjops.model.*;
import tms.findjops.repository.AdministratorRepository;
import tms.findjops.service.AdministratorService;
import tms.findjops.service.ApplicantService;
import tms.findjops.service.DTO.ResumeDTO;
import tms.findjops.service.EmployerService;
import tms.findjops.service.DTO.UserDTO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Data
@Controller
@RequestMapping("/user")
public class UserController {

    private final ApplicantService applicantService;
    private final EmployerService employerService;
    private final AdministratorService administratorService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)

    public String regUserG(){
        return "/reg";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String authUserG(){
        return "/auth";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String authUserP(UserDTO userDTO, HttpSession httpSession){
        Applicant applicant = applicantService.checkAuth(userDTO.getEmail(), userDTO.getPassword());
        Employer employer = employerService.checkAuth(userDTO.getEmail(), userDTO.getPassword());
        Administrator administrator = administratorService.checkAuth(userDTO.getEmail(), userDTO.getPassword());
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
        if (administrator != null){
            httpSession.setAttribute("currentAdministrator", administrator);
            httpSession.setAttribute("message", "Completed administrator auth");
            httpSession.setAttribute("checkRegAd", true);
            httpSession.setAttribute("checkReg", false);
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
        return ("redirect:/");
    }


}
