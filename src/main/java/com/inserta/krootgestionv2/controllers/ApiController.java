package com.inserta.krootgestionv2.controllers;

import com.inserta.krootgestionv2.models.*;
import com.inserta.krootgestionv2.services.ActividadesService;
import com.inserta.krootgestionv2.services.ComunicadosServices;
import com.inserta.krootgestionv2.services.EncuestasService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class ApiController {

    @Autowired
    private EncuestasService encuestasService;

    @Autowired
    private ComunicadosServices comunicadosService;

    @Autowired
    private ActividadesService actividadesService;

    @Autowired
    private SociosService sociosService;

    @GetMapping("/encuestas/{nombre}")
    public List<Encuesta> getEncuestas(@PathVariable String nombre){
        return encuestasService.findByNombre(nombre);
    }
    @GetMapping("/comunicados/actividad/{id}")
    public List<Comunicado> getComunicados(@PathVariable int id){
        return comunicadosService.getComunicadosByIdActividad(id);
    }
    @GetMapping("/actividades/tipo/{id}")
    public List<Actividad> getActividadesByTipo(@PathVariable int id){
        return actividadesService.getActividadesByTipo(id);
    }
    @GetMapping("/socios/fechaacceso/{fecha}")
    public List<Socio> getSociosByFecha(@PathVariable LocalDateTime fecha){
        return sociosService.getSociosByFechaUltimoAcceso(fecha);
    }
}
