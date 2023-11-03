package com.todocode.turnos.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

   private Long id;
   private String dni;
   private String nombre;
   private String apellido;   
   private LocalDate fechaNac;
   private String telefono;

}

//ESTA CLASE SERA UTILIZADA COMO UN DTO POR ESO NO PERSISTIRÁ EN LA DB