package com.todocode.pacientes.service;

import com.todocode.pacientes.model.Paciente;
import java.util.List;


public interface IPacienteService {
   
   public List<Paciente> getPacientes();

   public void savePaciente(Paciente p);

   public void deletePaciente(Long id);

   public Paciente findPaciente(Long id);

   public void editPaciente (Long id, Paciente p);

   public Paciente findPacienteByDni(String dni);

}
