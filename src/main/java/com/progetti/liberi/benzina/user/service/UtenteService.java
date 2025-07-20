package com.progetti.liberi.benzina.user.service;

import com.progetti.liberi.benzina.user.model.Utente;

import java.util.List;
import java.util.Optional;

public interface UtenteService {
    List<Utente> findAll();
    Optional<Utente> findById(Long id);
    Optional<Utente> findByUsername(String username);
    Utente save(Utente utente);
    void deleteById(Long id);

    Utente registerUser(Utente utente);
}
