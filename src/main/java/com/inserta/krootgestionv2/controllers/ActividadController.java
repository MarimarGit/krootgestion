package com.inserta.krootgestionv2.controllers;

import com.inserta.krootgestionv2.models.Actividad;
import com.inserta.krootgestionv2.models.TipoActividad;
import com.inserta.krootgestionv2.repos.ActividadesRepo;
import com.inserta.krootgestionv2.repos.TiposActividadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/actividades")
public class ActividadController {

    @Autowired
    private ActividadesRepo actividadesRepo;
    @Autowired
    private TiposActividadRepo tiposActividadRepo;

    @GetMapping
    public ResponseEntity<Page<Actividad>> listarActividades(Pageable pageable){
        return ResponseEntity.ok(actividadesRepo.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Actividad> guardarActividad(@RequestBody Actividad actividad) {
        System.out.println("Entro a guardar Actividad");
        //Para guardar una actividad primero miramos la id de tipoActividad con la que está relacionada
        Optional<TipoActividad> tipoActividadOptional = tiposActividadRepo.findById(actividad.getTipoActividad().getId());

        if (!tipoActividadOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        actividad.setTipoActividad(tipoActividadOptional.get());
        Actividad actividadGuardada = actividadesRepo.save(actividad);

        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(actividadGuardada.getId()).toUri();

        return ResponseEntity.created(ubicacion).body(actividadGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actividad> actualizarActividad(@PathVariable Integer id, @RequestBody Actividad actividad) {
        //Para guardar una actividad primero miramos la id de tipoActividad con la que está relacionada
        Optional<TipoActividad> tipoActividadOptional = tiposActividadRepo.findById(actividad.getTipoActividad().getId());

        if (!tipoActividadOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional <Actividad> actividadOptional = actividadesRepo.findById(id);
        if (!actividadOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        actividad.setTipoActividad(tipoActividadOptional.get());
        actividad.setId(actividadOptional.get().getId());
        actividadesRepo.save(actividad);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Actividad> eliminarActividad(@PathVariable Integer id) {
        //busco la actividad a eliminar con su id
        Optional <Actividad> actividadOptional = actividadesRepo.findById(id);

        if (!actividadOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        actividadesRepo.delete(actividadOptional.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actividad> obtenerActividadPorId(@PathVariable Integer id){
        //busco la actividad a listar con su id
        Optional <Actividad> actividadOptional = actividadesRepo.findById(id);

        if (!actividadOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(actividadOptional.get());
    }

}
