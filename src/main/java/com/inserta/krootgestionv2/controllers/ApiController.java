package com.inserta.krootgestionv2.controllers;

import com.inserta.krootgestionv2.models.*;
import com.inserta.krootgestionv2.services.ActividadesService;
import com.inserta.krootgestionv2.services.ComunicadosServices;
import com.inserta.krootgestionv2.services.EncuestasService;
import com.inserta.krootgestionv2.services.SociosService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
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

    @GetMapping("/socios/fechaacceso/{fecha}")
    public List<Socio> getSociosByFecha(@PathVariable LocalDateTime fecha){
        return sociosService.getSociosByFechaUltimoAcceso(fecha);
    }
   /* @DeleteMapping("/actividades/{id}")
    public void deleteActividadPorId() {
        actividadesService.deleteActividadById(id);
    }*/

    @ResponseBody
    @GetMapping("/socios/fechaUltimoAcceso/{year}/{month}/{day}")
    public List<Socio> sociosPorFechaUltimoAcceso(
            Model model,
            @PathVariable Integer year,
            @PathVariable Integer month,
            @PathVariable Integer day
    ) {
        //Primero recibo un String lo convierto a LocalDateTime porque es lo que recibe el método del repositorio
        LocalDateTime fechaUltimoAcceso = LocalDateTime.of(year, (month==null ? 1: month), (day!=null ? day:1), 0,0);
        List<Socio> listaSocios = sociosService.getSociosByFechaUltimoAcceso(fechaUltimoAcceso);
        return listaSocios;
    }

}
