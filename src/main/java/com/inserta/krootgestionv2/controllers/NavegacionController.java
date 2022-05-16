package com.inserta.krootgestionv2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacionController {
    @GetMapping("/actividadesPg")
    public String irAActividades(){
        return  "actividades-pg";
    }

    @GetMapping("/tiposActividadPg")
    public String IrATiposActividad(){
        return  "tiposActividad-pg";
    }

    @GetMapping("/comunicadosPg")
    public String irAComunicados(){
        return "comunicados-pg";
    }

    @GetMapping("/encuestasPg")
    public String irAEncuestas(){
        return "encuestas-pg";
    }

    @GetMapping("/sociosPg")
    public String irASocios(){
        return  "socios-pg";
    }

    @GetMapping("/usuarios")
    public String irAUsuarios(){
        return  "usuarios";
    }
}