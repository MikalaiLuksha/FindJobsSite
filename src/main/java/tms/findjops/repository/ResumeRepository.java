package tms.findjops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.Education;
import tms.findjops.model.Resume;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    List<Resume> findAllByApplicant_Id(long id);

}
