package com.inserta.krootgestionv2.controllers;

import com.inserta.krootgestionv2.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String inicio(@SessionAttribute(required = false) Usuario usuarioActivo) {
        if (usuarioActivo == null) { //si no hay nada en la sesión voy al login
            return "login";
        } else { //si hay algo en la sesión voy al index porque ya está logeado
            return "index";
        }
    }
}