package com.inserta.krootgestionv2.controllers;

import com.inserta.krootgestionv2.models.TipoSocio;
import com.inserta.krootgestionv2.repos.TipoSociosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3/tiposSocio")
public class TiposSocioController {

    @Autowired
    private TipoSociosRepo tipoSociosRepo;


    @GetMapping
    public ResponseEntity<Page<TipoSocio>> listarTiposSocios(Pageable pageable) {
        return ResponseEntity.ok(tipoSociosRepo.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<TipoSocio> guardarTipoSocio(@RequestBody TipoSocio tipoSocio) {
        //Recojo el TipoSocio enviado en la petición y lo guardo
        //Guardamos en tipoSocioGuardado el JSON que le pasamos por parámetro
        TipoSocio tipoSocioGuardado = tipoSociosRepo.save(tipoSocio);
        //Le pasamos la petición actual y le añade la id del tipoSocio que hemos guardado
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tipoSocioGuardado.getId()).toUri();

        //Le paso la ubicación y el cuerpo
        //Devolvemos una respuesta. En esta ubicación con id tal le estamos pasando el objeto tipoSocioGuardado
        //Cuando accedamos a la ruta ubicación vamos a retornar el objeto tipoSocioGuardado
        return ResponseEntity.created(ubicacion).body(tipoSocioGuardado);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TipoSocio> actualizarTipoSocio(@PathVariable Integer id, @RequestBody TipoSocio tipoSocio) {
        //Encontramos el tipoSocio con la id que nos han pasado. Optional devuelve true si lo encuentra y false en caso contrario
        Optional<TipoSocio> tipoSocioOptional = tipoSociosRepo.findById(id);
        if(!tipoSocioOptional.isPresent()) { //sino existe, devuelve UNPROCESSABLE ENTITY status (que no se ha podido procesar) y devuelve algo vacío
            ResponseEntity.unprocessableEntity().build();
        }

        //si existe
        tipoSocio.setId(tipoSocioOptional.get().getId()); //Establecemos la id con la que estamos atendiendo a este objeto
        tipoSociosRepo.save(tipoSocio);

        return ResponseEntity.noContent().build(); //No enviamos ningún contenido en la respuesta y construimos
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoSocio> eliminarTipoSocio(@PathVariable Integer id) {
        //Encontramos el tipoSocio con la id que nos han pasado para eliminar
        Optional<TipoSocio> tipoSocioOptional = tipoSociosRepo.findById(id);
        if(!tipoSocioOptional.isPresent()) { //sino existe, devuelve UNPROCESSABLE ENTITY status (que no se ha podido procesar) y devuelve algo vacío
            ResponseEntity.unprocessableEntity().build();
        }
        //si existe
        tipoSociosRepo.delete(tipoSocioOptional.get());
        return ResponseEntity.noContent().build(); //No enviamos ningún contenido en la respuesta y construimos
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoSocio> obtenerTipoSocioPorId(@PathVariable Integer id) {
        //Encontramos el tipoSocio con la id que nos han pasado para consultar
        Optional<TipoSocio> tipoSocioOptional = tipoSociosRepo.findById(id);
        if(!tipoSocioOptional.isPresent()) { //sino existe, devuelve UNPROCESSABLE ENTITY status (que no se ha podido procesar) y devuelve algo vacío
            ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(tipoSocioOptional.get());   //devuelve un json con el tipoSocio con id indicada

    }





   /* @GetMapping("/{id}")
    public ResponseEntity<TipoSocio> obtenerTiposSocioPorId(@PathVariable Integer id) {
        Optional<>
    }*/


}
