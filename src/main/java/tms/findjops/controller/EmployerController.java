package tms.findjops.controller;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tms.findjops.model.Employer;
import tms.findjops.service.ApplicantService;
import tms.findjops.service.EmployerService;

import javax.servlet.http.HttpSession;

@Data
@Controller
@RequestMapping("/user/employer")
public class EmployerController {

    private final EmployerService employerService;

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String regEmpP(Employer employer, HttpSession httpSession){
        if (employerService.checkEmployerReg(employer)){
            employerService.createEmployer(employer);
            httpSession.setAttribute("message", "Completed employer registration");
            return ("redirect:/");
        }
        else{httpSession.setAttribute("message", "Email already used");
            return ("redirect:/reg/applicant");
        }
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String accountG (){
        return "/employer/account";
    }
}
