package com.inserta.krootgestionv2.controllers;

import com.inserta.krootgestionv2.models.*;
import com.inserta.krootgestionv2.repos.ActividadesRepo;

import com.inserta.krootgestionv2.repos.SociosRepo;
import com.inserta.krootgestionv2.repos.UsuariosRepo;
import com.inserta.krootgestionv2.services.EncuestasService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class ApiController {

    @Autowired
    private ActividadesRepo actividadesRepo;

    @Autowired
    private SociosRepo sociosRepo;

    @Autowired
    private UsuariosRepo usuariosRepo;

    @Autowired
    private EncuestasService encuestasService;

    @Autowired
    private ComunicadosService comunicadosService;

    @GetMapping("/actividades")
    public List<Actividad> getActividad() {
        return actividadesRepo.findAll();
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return usuariosRepo.findAll();
    }

    @GetMapping("/socios")
    public List<Socio> getSocios(){
        return sociosRepo.findAll();
    }

    @GetMapping("/encuestas/{nombre}")
    public List<Encuesta> getEncuestas(@PathVariable String nombre){
        return encuestasService.findByNombre(nombre);
    }

    @GetMapping("/comunicados/actividad/{id}")
    public List<Comunicado> getComunicados(@PathVariable int id){
        return comunicadosService.getComunicadosByIdActividad(id);
    }
}
