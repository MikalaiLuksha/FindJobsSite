package tms.findjops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
