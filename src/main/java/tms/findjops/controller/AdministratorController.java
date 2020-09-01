package tms.findjops.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tms.findjops.model.Resume;
import tms.findjops.model.Status;
import tms.findjops.service.DTO.SortResumeListAdminDTO;
import tms.findjops.service.ResumeService;

import java.util.List;

@Data
@Controller
@RequestMapping("/administrator")
public class AdministratorController {

    private final ResumeService resumeService;

    @RequestMapping(value = "/resumeList", method = RequestMethod.GET)
    public String resumeList(Model model){
        List<Resume> resume = resumeService.getAllResume();
        model.addAttribute("resumes", resume);
        model.addAttribute("status", Status.values());
        return "/administrator/resumeList";
    }

    @RequestMapping(value = "/sortResume", method = RequestMethod.POST)
    public String sortResumeP(SortResumeListAdminDTO sortResumeListAdminDTO, Model model){
        List<Resume> resumes = resumeService.sortStatus(sortResumeListAdminDTO.getStatus());
        model.addAttribute("resumes", resumes);
        model.addAttribute("status", Status.values());
        return "/administrator/resumeList";
    }
}
