package com.todocode.turnos.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class TurnoDTO {
   
   private LocalDate fecha;
   private String tratamiento;
   private String dniPaciente;
}
