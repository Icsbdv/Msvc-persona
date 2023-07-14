package com.bdv.microservicios.Msvcpersona.services;



import com.bdv.microservicios.Msvcpersona.model.entities.Persona;
import com.bdv.microservicios.Msvcpersona.model.entities.PersonaOld;

import java.util.Optional;

public interface IPersonaService {
    PersonaOld guardarPersona(PersonaOld persona);

    void eliminarPersona(String personaId);
    Optional<Persona> consultarpersona(String personaId);
    Optional<Persona> consultarpersonaproducto(String personaId);

}
