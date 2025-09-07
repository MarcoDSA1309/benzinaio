package com.progetti.liberi.benzina.utility.general.home;

import com.progetti.liberi.benzina.datoBenzinaio.model.DatoBenzinaio;
import com.progetti.liberi.benzina.datoBenzinaio.service.DatoBenzinaioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class HomeController {

    private final DatoBenzinaioService datoBenzinaioService;

    public HomeController(DatoBenzinaioService datoBenzinaioService) {
        this.datoBenzinaioService = datoBenzinaioService;
    }

    @GetMapping({"/","home"})
    String getHomePage(Model model){
        Optional<DatoBenzinaio> datoBenzinaio = datoBenzinaioService.getLatestData();
        if (datoBenzinaio.isPresent()) {
            model.addAttribute("dataAggiornamento", datoBenzinaio.get().getData());
        } else {
            model.addAttribute("dataAggiornamento", "Nessuna data disponibile");
        }
        return "home";
    }
}
