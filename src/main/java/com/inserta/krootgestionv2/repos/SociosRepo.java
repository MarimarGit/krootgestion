package com.inserta.krootgestionv2.repos;

import com.inserta.krootgestionv2.models.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RepositoryRestResource(path = "socios")
public interface SociosRepo extends JpaRepository<Socio, Integer> {

    /**
     * Encuentra una lista de socios por fecha de último acceso
     * @param fecha La fecha de último acceso
     * @return List de socios
     */
    List<Socio> findByFechaUltimoAcceso(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha);
}
