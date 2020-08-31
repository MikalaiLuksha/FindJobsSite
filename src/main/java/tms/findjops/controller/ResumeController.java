package tms.findjops.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tms.findjops.model.*;
import tms.findjops.service.DTO.ResumeDTO;
import tms.findjops.service.ResumeService;

import javax.servlet.http.HttpSession;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Data
@Controller
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @RequestMapping(value = "/addResume", method = RequestMethod.GET)
    public String addResumeG (Model model){
        List<Language> allLanguage = resumeService.getAllLanguage();
        List<Profession> allProfession = resumeService.getAllProfession();
        model.addAttribute("languages", allLanguage);
        model.addAttribute("professions", allProfession);
        return "/resume/addResume";
    }

    @RequestMapping(value = "/addResume", method = RequestMethod.POST)
    public String addResumeP (ResumeDTO resumeDTO, HttpSession httpSession){
        Applicant currentApplicant = (Applicant) httpSession.getAttribute("currentApplicant");
        resumeDTO.setApplicant(currentApplicant);
        httpSession.setAttribute("resumeDTO", resumeDTO);
        List<PlaceOfWork> listPlaceOfWorks = new ArrayList<>();
        httpSession.setAttribute("listPlaceOfWorks", listPlaceOfWorks);
        List<Education> listEducations = new ArrayList<>();
        httpSession.setAttribute("listEducations", listEducations);
        return ("redirect:/resume/addWorks");
    }

    @RequestMapping(value = "/addWorks", method = RequestMethod.GET)
    public String addWorksG (HttpSession httpSession){
        ResumeDTO resumeDTO = (ResumeDTO) httpSession.getAttribute("resumeDTO");
        String placeOfWorks = resumeDTO.getWorkExperience();
        if (placeOfWorks.equals("No")){return ("redirect:/resume/addEducation");}
        else {
            return "/resume/addWork";}
    }

    @RequestMapping(value = "/addWorks", method = RequestMethod.POST)
    public String addWorksG (PlaceOfWork placeOfWork, HttpSession httpSession, String key) {
        List<PlaceOfWork> listPlaceOfWorks = (List<PlaceOfWork>) httpSession.getAttribute("listPlaceOfWorks");
        listPlaceOfWorks.add(placeOfWork);
        httpSession.setAttribute("listPlaceOfWorks", listPlaceOfWorks);
        if (key.equals("1")) {
            return "/resume/addWork";
        }
        if (key.equals("2")) {
            return "redirect:/resume/addEducation";
        }
        return "/";
    }


    @RequestMapping(value = "/addEducation", method = RequestMethod.GET)
    public String addEducationG (HttpSession httpSession){
        ResumeDTO resumeDTO = (ResumeDTO) httpSession.getAttribute("resumeDTO");
        String educations = resumeDTO.getEducationLevel();
        if (educations.equals("School")){
            List<Education> listEducations = (List<Education>) httpSession.getAttribute("listEducations");
            List<PlaceOfWork> listPlaceOfWorks = (List<PlaceOfWork>) httpSession.getAttribute("listPlaceOfWorks");
            listEducations.add(new Education(resumeDTO.getEducationLevel()));
            resumeService.createResume(resumeDTO, listPlaceOfWorks, listEducations);
            return ("redirect:/");}
        else {
            return "/resume/addEducation";}
    }

    @RequestMapping(value = "/addEducation", method = RequestMethod.POST)
    public String addEducationP (Education education, HttpSession httpSession, String key){
        List<Education> listEducations = (List<Education>) httpSession.getAttribute("listEducations");
        ResumeDTO resumeDTO = (ResumeDTO) httpSession.getAttribute("resumeDTO");
        listEducations.add(education);
        httpSession.setAttribute("listEducations", listEducations);
        if (key.equals("1")) {
            return "/resume/addEducation";
        }
        if (key.equals("2")) {
            List<PlaceOfWork> listPlaceOfWorks = (List<PlaceOfWork>) httpSession.getAttribute("listPlaceOfWorks");
            resumeService.createResume(resumeDTO, listPlaceOfWorks, listEducations);
            return "redirect:/";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/youResume", method = RequestMethod.GET)
    public String youResumeG(HttpSession httpSession, Model model){
        Applicant currentApplicant = (Applicant) httpSession.getAttribute("currentApplicant");
        List<Resume> allApplicantResume = resumeService.getAllApplicantResume(currentApplicant.getId());
        model.addAttribute("allApplicantResume", allApplicantResume);
        return "/resume/youResume";
    }

    @RequestMapping(value = "/resume/{id}", method = RequestMethod.GET)
    public String ResumeG(Model model, @PathVariable(name = "id") long id, HttpSession httpSession){
        Resume resume = resumeService.getResume(id);
        model.addAttribute("resume", resume);
        Period age = resumeService.getAge(resume);
        model.addAttribute("age", age);
        Applicant currentApplicant = (Applicant) httpSession.getAttribute("currentApplicant");
        if (currentApplicant.getId() == resume.getApplicant().getId()){
            model.addAttribute("checkUpd", "yes");
        }
        return "/resume/resume";
    }

    @RequestMapping(value = "/deleted/{id}", method = RequestMethod.POST)
    public String Deleted(@PathVariable(name = "id") long id){
        resumeService.deleted(id);
        return ("redirect:/resume/youResume");
    }

    @RequestMapping(value = "/resumeList", method = RequestMethod.GET)
    public String resumeListG(Model model){
        List<Resume> allResume = resumeService.getAllResume();
        model.addAttribute("resumes", allResume);
        List<Profession> professions = resumeService.getAllProfession();
        model.addAttribute("profs", professions);
        return "/resume/resumeList";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateG(Model model, @PathVariable(name = "id") long id){
        Resume resume = resumeService.getResume(id);
        model.addAttribute("resume", resume);
        Period age = resumeService.getAge(resume);
        model.addAttribute("age", age);
        return "/resume/updateResume";
    }

    @RequestMapping(value = "/updateMain/{id}", method = RequestMethod.GET)
    public String updateMainP(@PathVariable(name = "id") long id, Model model){
        Resume resume = resumeService.getResume(id);
        model.addAttribute("resume", resume);
        List<Language> allLanguage = resumeService.getAllLanguage();
        List<Profession> allProfession = resumeService.getAllProfession();
        model.addAttribute("languages", allLanguage);
        model.addAttribute("professions", allProfession);
        return "/resume/resumeMainUpdate";
    }





}
