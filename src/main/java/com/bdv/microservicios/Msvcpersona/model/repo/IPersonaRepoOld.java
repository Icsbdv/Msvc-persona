package com.bdv.microservicios.Msvcpersona.model.repo;




import com.bdv.microservicios.Msvcpersona.model.entities.PersonaOld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepoOld extends JpaRepository<PersonaOld,String> {

    @Procedure
    void sp_PEOPLE(@Param("Accion") String Accion,
                  @Param("sPersonaId") String sPersonaId,
                  @Param("sPersona") String sPersona,
                  @Param("sDireccion") String sDireccion,
                  @Param("sUser") String sUser

    );
    @Query(value="Select p from PersonaOld p where p.personaid=?1")
    PersonaOld findPersonaByPersonaId(String personaId);

    PersonaOld findByPersonaid(String personaId);

}
