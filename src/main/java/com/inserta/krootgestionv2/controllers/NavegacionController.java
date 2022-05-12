package com.inserta.krootgestionv2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacionController {

    @GetMapping("/actividades")
    public String irAActividades(){
        return  "actividades";
    }

    @GetMapping("/comunicados")
    public String irAComunicados(){
        return  "comunicados";
    }

    @GetMapping("/encuestas")
    public String irAEncuestas(){
        return  "encuestas";
    }

    @GetMapping("/socios")
    public String irASocios(){
        return  "socios";
    }
}
