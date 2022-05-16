package com.inserta.krootgestionv2.repos;

import com.inserta.krootgestionv2.models.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "actividades", collectionResourceRel = "actividades")

public interface ActividadesRepo extends JpaRepository<Actividad, Integer> {
}
