package com.inserta.krootgestionv2.controllers;

import com.inserta.krootgestionv2.models.*;
import com.inserta.krootgestionv2.repos.ActividadesRepo;
import com.inserta.krootgestionv2.repos.EncuestasRepo;
import com.inserta.krootgestionv2.repos.SociosRepo;
import com.inserta.krootgestionv2.repos.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    private ActividadesRepo actividadesRepo;

    @Autowired
    private SociosRepo sociosRepo;

    @Autowired
    private UsuariosRepo usuariosRepo;

    @Autowired
    private EncuestasRepo encuestasRepo;

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
    @GetMapping("/encuestas")
    public List<Encuesta> getEncuestas(){
        return encuestasRepo.findAll();
    }

}
