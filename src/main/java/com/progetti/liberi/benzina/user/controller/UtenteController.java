package com.progetti.liberi.benzina.user.controller;

import com.progetti.liberi.benzina.user.model.Utente;
import com.progetti.liberi.benzina.user.service.UtenteService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/utenti")
public class UtenteController {

    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping("/lista")
    public String listUtenti(Model model) {
        List<Utente> utenti = utenteService.findAll();
        model.addAttribute("utenti", utenti);
        return "utenti/lista"; // -> templates/utenti/lista.html
    }

    @GetMapping("/nuovo")
    public String showForm(Model model) {
        model.addAttribute("utente", new Utente());
        return "utenti/nuovo"; // -> templates/utenti/nuovo.html
    }

    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String salvaUtente(@ModelAttribute Utente utente) {
        utenteService.registerUser(utente);
        return "redirect:/utenti";
    }
/* API
@PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<?> salvaUtenteJson(@RequestBody Utente utente) {
    userService.registerUser(utente);
    return ResponseEntity.ok("User created");
 */
    @GetMapping("/elimina/{id}")
    public String eliminaUtente(@PathVariable Long id) {
        utenteService.deleteById(id);
        return "redirect:/utenti";
    }
}