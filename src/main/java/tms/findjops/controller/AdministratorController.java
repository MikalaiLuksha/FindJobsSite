package tms.findjops.controller;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tms.findjops.model.Advert;
import tms.findjops.model.Employer;
import tms.findjops.model.Resume;
import tms.findjops.model.Status;
import tms.findjops.service.AdvertService;
import tms.findjops.service.DTO.SortAdvertListAdminDTO;
import tms.findjops.service.DTO.SortResumeListAdminDTO;
import tms.findjops.service.DTO.StatusDTO;
import tms.findjops.service.ResumeService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Data
@Controller
@RequestMapping("/administrator")
public class AdministratorController {

    private final ResumeService resumeService;
    private final AdvertService advertService;

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

    @RequestMapping(value = "/advertList", method = RequestMethod.GET)
    public String advertListG(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Advert> page = advertService.getAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/");
        model.addAttribute("status", Status.values());
        return "/administrator/advertList";
    }

    @RequestMapping(value = "/sortAdvert", method = RequestMethod.POST)
    public String sortAdvertP(SortAdvertListAdminDTO sortAdvertListAdminDTO, Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Advert> page = advertService.getAllByStatus(sortAdvertListAdminDTO.getStatus(), pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/");
        model.addAttribute("status", Status.values());
        return "/administrator/advertList";
    }

    @RequestMapping(value = "/advert/{id}", method = RequestMethod.GET)
    public String advertG (Model model, @PathVariable(name = "id") long id){
        Advert advertById = advertService.getAdvertById(id);
        model.addAttribute("advert", advertById);
        model.addAttribute("checkEmp", "yes");
        model.addAttribute("status", Status.values());
        return "/administrator/advert";
    }

    @RequestMapping(value = "/setStatus/{id}", method = RequestMethod.POST)
    public String serStatusP(@PathVariable(name = "id") long id, StatusDTO statusDTO, Model model){
        Advert advert = advertService.updateStatus(statusDTO.getStatus(), id);
        model.addAttribute("advert", advert);
        model.addAttribute("checkEmp", "yes");
        model.addAttribute("status", Status.values());
        return "/administrator/advert";
    }
}
