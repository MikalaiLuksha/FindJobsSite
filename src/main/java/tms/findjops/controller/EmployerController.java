package tms.findjops.controller;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tms.findjops.model.Employer;
import tms.findjops.model.Gender;
import tms.findjops.model.Nationality;
import tms.findjops.service.ApplicantService;
import tms.findjops.service.EmployerService;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping(value = "/account/update", method = RequestMethod.GET)
    public String updateAccountG (Model model){
        return "/employer/updateAccount";
    }

    @RequestMapping(value = "/account/update", method = RequestMethod.POST)
    public String updateAccountP (Employer employer, HttpSession httpSession){
        Employer currentEmployer = (Employer) httpSession.getAttribute("currentEmployer");
        Employer employer1 = employerService.updateEmployer(employer, currentEmployer.getId());
        httpSession.setAttribute("currentEmployer", employer1);
        return "/employer/account";
    }
}
