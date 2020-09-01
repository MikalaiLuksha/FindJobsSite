package tms.findjops.service;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tms.findjops.model.*;
import tms.findjops.repository.*;
import tms.findjops.service.DTO.ResumeDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Data
public class ResumeService {

    private final ApplicantRepository applicantRepository;
    private final NationalityRepository nationalityRepository;
    private final LanguageRepository languageRepository;
    private final ProfessionRepository professionRepository;
    private final PlaceOfWorksRepository placeOfWorksRepository;
    private final EducationRepository educationRepository;
    private final ResumeRepository resumeRepository;
    private final ModelMapper modelMapper;


    public List<Language> getAllLanguage (){
        return languageRepository.findAll();
    }

    public List<Profession> getAllProfession(){return professionRepository.findAll();}

    public void createResume (ResumeDTO resumeDTO, List<PlaceOfWork> workList, List<Education> educationList){
        Resume resume = convertResume(resumeDTO, workList, educationList);
        placeOfWorksRepository.saveAll(workList);
        educationRepository.saveAll(educationList);
        resumeRepository.save(resume);
    }


    private Resume convertResume (ResumeDTO resumeDTO, List<PlaceOfWork> workList, List<Education> educationList){
        Resume resume = modelMapper.map(resumeDTO, Resume.class);
        resume.setPlaceOfWorks(workList);
        resume.setEducations(educationList);
        resume.setStatus(Status.unchecked);
        return resume;
    }

    public List<Resume> getAllApplicantResume(long id){
        return resumeRepository.findAllByApplicant_Id(id);
    }

    public List<Resume> getAllResume(){
        return resumeRepository.findAll();
    }

    public Resume getResume(long id){
        return resumeRepository.getOne(id);
    }

    public void deleted (long id){
        resumeRepository.deleteById(id);
        placeOfWorksRepository.deleteById(id);
        professionRepository.deleteById(id);
    }

    public Period getAge(Resume resume){
        Calendar calendar = resume.getApplicant().getBirthday();
        LocalDate endDate = LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId()).toLocalDate();
        LocalDate startDate = LocalDate.now();
        return Period.between(endDate, startDate);
    }

    public void updateMain(ResumeDTO resumeDTO, long id){
        Resume one = resumeRepository.getOne(id);
        one.setProfession(resumeDTO.getProfession());
        one.setSalary(resumeDTO.getSalary());
        one.setNativeLanguage(resumeDTO.getNativeLanguage());
        one.setForeignLanguages(resumeDTO.getForeignLanguages());
        one.setAboutMyself(resumeDTO.getAboutMyself());
        resumeRepository.save(one);
    }

    public Education getEducation (long id){
        return educationRepository.getOne(id);
    }

    public void updateEducation (Education education, long id){
        Education one = educationRepository.getOne(id);
        one.setLevel(education.getLevel());
        one.setEducationalInstitution(education.getEducationalInstitution());
        one.setFaculty(education.getFaculty());
        one.setSpecialization(education.getSpecialization());
        one.setYearOfEnding(education.getYearOfEnding());
        educationRepository.save(one);
    }

    public PlaceOfWork getPOW (long id){
        return placeOfWorksRepository.getOne(id);
    }

    public void updatePOW(PlaceOfWork placeOfWork, long id){
        PlaceOfWork one = placeOfWorksRepository.getOne(id);
        one.setBeginningOfWork(placeOfWork.getBeginningOfWork());
        one.setEndOfWork(placeOfWork.getEndOfWork());
        one.setOrganization(placeOfWork.getOrganization());
        one.setPosition(placeOfWork.getPosition());
        one.setWorkplaceResponsibilities(placeOfWork.getWorkplaceResponsibilities());
        placeOfWorksRepository.save(one);
    }

    public List<Resume> sortStatus (Status status){
        List<Resume> allResume = getAllResume();
        List<Resume> sortList = new ArrayList<>();
        for ( Resume re: allResume)
        {
            if (re.getStatus() == status){
                sortList.add(re);
            }

        }
        return sortList;
    }

}
