package com.inserta.krootgestionv2.repos;

import com.inserta.krootgestionv2.models.TipoSocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "tiposSocio", collectionResourceRel = "tiposSocio")
public interface TipoSociosRepo extends JpaRepository<TipoSocio, Integer> {

}
