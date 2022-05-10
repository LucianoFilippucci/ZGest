package it.lucianofilippucci.zgest.repositories;

import it.lucianofilippucci.zgest.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}