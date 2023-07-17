package com.bdv.microservicios.Msvcpersona.model.repo;

import com.bdv.microservicios.Msvcpersona.model.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona,String> {
    @Query(value="Select p.ID_Persona as ID_PERSONA," +
            "p.Nombre as NOMBRE," +
            "p.Direccion AS DIRECCION" +
            " from Persona p " +
            "where p.ID_Persona=?1",nativeQuery = true)
    Optional<Persona> findByIdPersona(String idPersona);

    @Query(value="Select p.ID_Persona as ID_PERSONA," +
            "p.Nombre as NOMBRE," +
            "p.Direccion AS DIRECCION" +
            " from Persona p" +
            " inner join Producto pr" +
            " on p.ID_Persona=pr.ID_Titular " +
            " where p.ID_Persona=?1",nativeQuery = true)
    Optional<Persona> findByIdPersonaProducto(String idPersona);

    @Query(value="Delete from Persona where ID_Persona=?1",nativeQuery = true)
    void eliminarPersona(String idPersona);
}
