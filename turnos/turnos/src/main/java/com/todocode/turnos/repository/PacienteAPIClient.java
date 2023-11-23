package com.todocode.turnos.repository;

import com.todocode.turnos.model.Paciente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="pacienteapi", url="http://localhost:9010/pacientes/traerdni")
public interface PacienteAPIClient {
   
   @GetMapping("/{dni}")
   public Paciente getPacienteByDni(@PathVariable String dni);
}
