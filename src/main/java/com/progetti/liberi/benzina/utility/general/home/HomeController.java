package com.progetti.liberi.benzina.utility.general.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/","home"})
    String getHomePage(){
        return "home";
    }
}
