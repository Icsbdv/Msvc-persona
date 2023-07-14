package com.bdv.microservicios.Msvcpersona.controller;



import com.bdv.microservicios.Msvcpersona.model.entities.Persona;
import com.bdv.microservicios.Msvcpersona.model.entities.PersonaOld;
import com.bdv.microservicios.Msvcpersona.model.entities.Responses;
import com.bdv.microservicios.Msvcpersona.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("app")
public class Personacontroller {



    @Autowired
    IPersonaService iPersonaService;




    @PostMapping("/crearpersona")
    public ResponseEntity<?> crearPersona(@RequestBody PersonaOld persona){
        PersonaOld personaguardada=iPersonaService.guardarPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaguardada);
    }

    @DeleteMapping("/eliminarpersona")
    public ResponseEntity<Responses> eliminarPersona(@RequestParam String idPersona){
        Optional<Persona> optionalPersona=iPersonaService.consultarpersona(idPersona);
        if(optionalPersona.isPresent()) {
            Optional<Persona> optionalPersonaProducto=iPersonaService.consultarpersonaproducto(idPersona);
            if(!optionalPersonaProducto.isPresent()) {
                iPersonaService.eliminarPersona(idPersona);
                return ResponseEntity.ok(new Responses("Persona eliminada satisfactoriamente"));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Responses("La persona no puede ser eliminada por poseer mas de un producto"));
            }
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Responses("Persona no existente en la base de datos"));
        }
    }


    //@DeleteMapping("/eliminarpersona")
   // public ResponseEntity<?> eliminarPersona(@RequestParam String idPersona){
        //Persona persona=iPersonaService.consultarpersona(idPersona);
      //  if(persona==null){
           // return ResponseEntity.notFound().build();
        //}else {
         //   iPersonaService.eliminarPersona(idPersona);
         //   return ResponseEntity.noContent().build();
       // }
   // }



}
