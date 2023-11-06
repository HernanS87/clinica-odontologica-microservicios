package com.todocode.pacientes.service;

import com.todocode.pacientes.model.Paciente;
import com.todocode.pacientes.repository.IPacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService implements IPacienteService{
   
   @Autowired
   IPacienteRepository pacienteRepository;

   @Override
   public List<Paciente> getPacientes() {
      return pacienteRepository.findAll();
   }

   @Override
   public void savePaciente(Paciente p) {
      pacienteRepository.save(p);
   }

   @Override
   public void deletePaciente(Long id) {
      pacienteRepository.deleteById(id);
   }

   @Override
   public Paciente findPaciente(Long id) {
      return pacienteRepository.findById(id).orElse(null);
   }

   @Override
   public void editPaciente(Long id, Paciente p) { //tengo el id como parametro pero no lo utilizo?
      this.savePaciente(p);
   }

   @Override
   public Paciente findPacienteByDni(String dni) {
      return pacienteRepository.findByDni(dni);
   }
}
