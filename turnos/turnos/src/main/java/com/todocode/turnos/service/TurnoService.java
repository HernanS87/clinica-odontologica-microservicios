package com.todocode.turnos.service;

import com.todocode.turnos.model.Turno;
import com.todocode.turnos.repository.ITurnoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService implements ITurnoService{
   
   @Autowired
   ITurnoRepository turnoRepository;
   
   @Override
   public List<Turno> getTurnos() {
      return turnoRepository.findAll();
   }

   @Override
   public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {

      //buscar el paciente en la api pacientes
      //Paciente pac = //buscar en la api
      //String nombreCompletoPaciente = //lo que consumo de nombre de la api;

      Turno turno = new Turno();
      turno.setFecha(fecha);
      turno.setTratamiento(tratamiento);
      //turno.setNombreCompletoPaciente();

      turnoRepository.save(turno);
   }

   @Override
   public void deleteTurno(Long id) {
      turnoRepository.deleteById(id);
   }

   @Override
   public Turno findTurno(Long id) {
      return turnoRepository.findById(id).orElse(null);
   }

   @Override
   public void editTurno(Long id, Turno t) {

      Turno turno = this.findTurno(id);

      turno.setFecha(t.getFecha());
      turno.setTratamiento(t.getTratamiento());
      turno.setNombreCompletoPaciente(t.getNombreCompletoPaciente());

      turnoRepository.save(turno);
   }
}
