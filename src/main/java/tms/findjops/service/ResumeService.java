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
import java.time.format.DateTimeFormatter;
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
}
