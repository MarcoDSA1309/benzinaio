package com.progetti.liberi.benzina.user.service.impl;

import com.progetti.liberi.benzina.user.model.Utente;
import com.progetti.liberi.benzina.user.repository.UtenteRepository;
import com.progetti.liberi.benzina.user.service.UtenteService;
import com.progetti.liberi.benzina.utility.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteServiceStandard implements UtenteService {

    private final UtenteRepository utenteRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UtenteServiceStandard(UtenteRepository utenteRepository,PasswordEncoder passwordEncoder) {
        this.utenteRepository = utenteRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }

    @Override
    public Optional<Utente> findById(Long id) {
        return utenteRepository.findById(id);
    }

    @Override
    public Optional<Utente> findByUsername(String username) {
        return utenteRepository.findByUsername(username);
    }

    @Override
    public Utente save(Utente utente) {
        return utenteRepository.save(utente);
    }

    @Override
    public void deleteById(Long id) {
        utenteRepository.deleteById(id);
    }

    public Utente registerUser(Utente utente){
        utente.setPassword(
                passwordEncoder.getPasswordEncoder().encode(utente.getPassword()
                ));
        return save(utente);
    }
}
