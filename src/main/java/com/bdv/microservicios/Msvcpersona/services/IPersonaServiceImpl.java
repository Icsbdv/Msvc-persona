package com.bdv.microservicios.Msvcpersona.services;


import com.bdv.microservicios.Msvcpersona.model.entities.Persona;
import com.bdv.microservicios.Msvcpersona.model.entities.PersonaOld;
import com.bdv.microservicios.Msvcpersona.model.repo.IPersonaRepo;
import com.bdv.microservicios.Msvcpersona.model.repo.IPersonaRepoOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class IPersonaServiceImpl implements IPersonaService {



    //@Autowired
    //IPersonaRepo personaRepo;

    @Autowired
    IPersonaRepo personRepo;

    @Autowired
    IPersonaRepoOld personRepoOld;






    @Override
    @Transactional
    public PersonaOld guardarPersona(PersonaOld persona) {

        String personaId=persona.getPersonaid();
        String personanombre=persona.getPersona();
        String direccion=persona.getDireccion();
        String user=persona.getUser();

        personRepoOld.sp_PEOPLE("INSERT",personaId,personanombre,direccion,user);

        return persona;
    }

    @Override
    public void eliminarPersona(String personaId) {

      //  String personaId=persona.getPersonaid();
        String personanombre="";
        String direccion="";
       // String user=persona.getUser();
        String user="PLATAFORMA";
   //     Integer coddigo=personaRepo.sp_PEOPLE("SELECT",personaId,personanombre,direccion,user);
        personRepoOld.sp_PEOPLE("DELETE",personaId,personanombre,direccion,user);

       // personRepo.eliminarPersona(personaId);

    }

    @Override
    public Optional<Persona> consultarpersona(String personaId) {
        return personRepo.findByIdPersona(personaId);
    }

    @Override
    public Optional<Persona> consultarpersonaproducto(String personaId) {
        return personRepo.findByIdPersonaProducto(personaId);
    }
}
