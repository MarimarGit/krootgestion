package com.inserta.krootgestionv2.repos;

import com.inserta.krootgestionv2.models.Encuesta;
import com.inserta.krootgestionv2.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "encuestas")
public interface EncuestasRepo extends JpaRepository<Encuesta, Integer> {
    /**
     * Obtiene la encuesta por el nombre de esta
     * @param nombre String con el nombre de la encuesta
     * @return Encuesta con el nombre de la encuesta
     */
    public List<Encuesta> findByNombre(String nombre);

}
