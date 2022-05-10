package it.lucianofilippucci.zgest.repositories;

import it.lucianofilippucci.zgest.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

}
