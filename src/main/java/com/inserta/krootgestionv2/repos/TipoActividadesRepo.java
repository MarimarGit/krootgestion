package com.inserta.krootgestionv2.repos;

import com.inserta.krootgestionv2.models.TipoActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "tipoActividades", collectionResourceRel = "tipoActividades")
public interface TipoActividadesRepo extends JpaRepository<TipoActividad, Integer> {
}
