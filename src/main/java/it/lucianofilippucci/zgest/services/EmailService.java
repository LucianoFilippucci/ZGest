package it.lucianofilippucci.zgest.services;

import it.lucianofilippucci.zgest.entities.Email;
import it.lucianofilippucci.zgest.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Transactional(readOnly = true)
    public List<Email> getAll() {
        return emailRepository.findAll();
    }
}
