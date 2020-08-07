package tms.findjops.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tms.findjops.model.Applicant;
import tms.findjops.model.Employer;
import tms.findjops.service.ApplicantService;
import tms.findjops.service.EmployerService;

@Data
@Controller
@RequestMapping("/user")
public class UserController {

    private final ApplicantService applicantService;
    private final EmployerService employerService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String regUserG(){
        return "reg";
    }

    @RequestMapping(value = "/reg/applicant", method = RequestMethod.POST)
    public String regApplP(Applicant applicant){
        applicantService.createApplicant(applicant);
        return ("/");

    }

    @RequestMapping(value = "/reg/employer", method = RequestMethod.POST)
    public String regEmpP(Employer employer){
        employerService.createEmployer(employer);
        return ("/");
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String authUser(){
        return "auth";
    }


}
