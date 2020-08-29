package tms.findjops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.findjops.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Administrator findByEmail(String email);
}
