package com.bdv.microservicios.Msvcpersona.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "agregarPersona",
                procedureName = "sp_PEOPLE",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Accion", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sPersonaId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sPersona", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sDireccion", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sUser", type = String.class),
                })

})


public class PersonaOld implements Serializable {

    @Id
    String personaid;


    String persona;


    String direccion;


    String user;


}
