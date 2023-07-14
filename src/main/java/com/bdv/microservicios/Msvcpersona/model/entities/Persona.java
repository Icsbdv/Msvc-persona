package com.bdv.microservicios.Msvcpersona.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "Persona")
public class Persona implements Serializable {
    @Id
    @Column(name = "Id_Persona")
    String personaid;

    @Column(name = "Nombre")
    String nombre;

    @Column(name = "Direccion")
    String direccion;

}
