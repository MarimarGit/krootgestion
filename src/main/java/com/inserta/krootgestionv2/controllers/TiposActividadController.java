package com.inserta.krootgestionv2.controllers;

import com.inserta.krootgestionv2.models.TipoActividad;
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
@RequestMapping("/api/v2/tiposActividad")

public class TiposActividadController {

    @Autowired
    private TiposActividadRepo tiposActividadRepo;


    @GetMapping
    public ResponseEntity<Page<TipoActividad>> listarBibliotecas(Pageable pageable){
        return ResponseEntity.ok(tiposActividadRepo.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<TipoActividad> guardarTipoActividad(@RequestBody TipoActividad tipoActividad) {
        System.out.println("Entro a guardar nuevo tipoActividad");
        TipoActividad tipoActividadGuardado = tiposActividadRepo.save(tipoActividad);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tipoActividadGuardado.getId()).toUri();

        return ResponseEntity.created(ubicacion).body(tipoActividadGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoActividad> actualizarTipoActividad(@PathVariable Integer id, @RequestBody TipoActividad tipoActividad) {
        //Encontramos el tipoActividad que queremos actualizar
        Optional<TipoActividad> tipoActividadActual = tiposActividadRepo.findById(id);

        if (!tipoActividadActual.isPresent()) { //Si no lo encontramos devolvemos un no podemos procesar la petición
            return ResponseEntity.unprocessableEntity().build();
        }

        tipoActividad.setId(tipoActividadActual.get().getId());
        tiposActividadRepo.save(tipoActividad); //Guardamos el tipoActividad actualizado

        return ResponseEntity.noContent().build();  //Devolvemos un código 204 que no enviamos ningún contenido pero ya hemos guardado en la bd
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoActividad> borrarTipoActividad(@PathVariable Integer id) {
        //Encontramos el tipoActividad que queremos eliminar
        Optional<TipoActividad> tipoActividadActual = tiposActividadRepo.findById(id);

        if (!tipoActividadActual.isPresent()) { //Si no lo encontramos devolvemos un no podemos procesar la petición
            return ResponseEntity.unprocessableEntity().build();
        }

        tiposActividadRepo.delete(tipoActividadActual.get()); //Eliminamos el tipoActividad
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoActividad> obtenerTipoActividadPorId(@PathVariable Integer id) {
        //Encontramos el tipoActividad que queremos mostrar
        Optional<TipoActividad> tipoActividadActual = tiposActividadRepo.findById(id);

        if (!tipoActividadActual.isPresent()) { //Si no lo encontramos devolvemos un no podemos procesar la petición
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(tipoActividadActual.get()); //Devolvemos el tipoActividad en Json
    }

}
