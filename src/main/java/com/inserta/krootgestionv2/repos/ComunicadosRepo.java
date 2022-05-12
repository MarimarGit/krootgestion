package com.inserta.krootgestionv2.repos;

import com.inserta.krootgestionv2.models.Comunicado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "comunicados")
public interface ComunicadosRepo extends JpaRepository<Comunicado, Integer> {

    public List<Comunicado> findComunicadoByIdActividad(int id);

}
