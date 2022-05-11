package com.inserta.krootgestionv2.repos;

import com.inserta.krootgestionv2.models.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "encuestas")
public interface EncuestasRepo extends JpaRepository<Encuesta, Integer> {

}
