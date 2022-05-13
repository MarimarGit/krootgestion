package com.inserta.krootgestionv2.repos;

import com.inserta.krootgestionv2.models.Actividad;
import com.inserta.krootgestionv2.models.TipoActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RepositoryRestResource(path = "actividades")
public interface ActividadesRepo extends JpaRepository<Actividad,Integer> {



    public List<Actividad> findByTipoActividad(TipoActividad tipoActividad);











}
