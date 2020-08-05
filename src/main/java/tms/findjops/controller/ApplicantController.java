package tms.findjops.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tms.findjops.model.Applicant;
import tms.findjops.service.UserService;

@Data
@Controller
@RequestMapping("/user")
public class ApplicantController {

    private final UserService userService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String regUserG(){
        return "regUser";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String regUserP(Applicant user){
        userService.creatUser(user);
        return ("/addPersonalInformation");

    }


}
