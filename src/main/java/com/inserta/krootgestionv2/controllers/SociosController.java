package com.inserta.krootgestionv2.controllers;

import com.inserta.krootgestionv2.models.Socio;
import com.inserta.krootgestionv2.repos.SociosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v3/socios")
public class SociosController {

    @Autowired
    private SociosRepo sociosRepo;

    @GetMapping
    public ResponseEntity<Page<Socio>> listarSocios(Pageable pageable) {
        return ResponseEntity.ok(sociosRepo.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Socio> obtenerSocioPorId(@PathVariable Integer id) {
        //Encontramos el socio con la id indicada
        Optional<Socio> socioOptional = sociosRepo.findById(id);

        //Compruebo si existe
        if (!socioOptional.isPresent()) { //Si no está devuelve que no se puede procesar
            ResponseEntity.unprocessableEntity().build();
        }
        //si lo ha encontrado lo devuelve
        return ResponseEntity.ok(socioOptional.get());  //devuelve un json con el socio cuya id se ha indicado
    }

}
