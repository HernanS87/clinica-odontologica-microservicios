package com.todocode.turnos.service;

import com.todocode.turnos.model.Paciente;
import com.todocode.turnos.model.Turno;
import com.todocode.turnos.repository.ITurnoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TurnoService implements ITurnoService{
   
   @Autowired
   ITurnoRepository turnoRepository;
   @Autowired
   RestTemplate apiConsumir;
   
   @Override
   public List<Turno> getTurnos() {
      return turnoRepository.findAll();
   }

   @Override
   public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {

      Paciente p = apiConsumir.getForObject("http://localhost:9010/pacientes/traerdni/" + dniPaciente, Paciente.class);
      String nombreCompletoPaciente = p.getNombre() + " " + p.getApellido();
      
      Turno turno = new Turno();
      turno.setFecha(fecha);
      turno.setTratamiento(tratamiento);
      turno.setNombreCompletoPaciente(nombreCompletoPaciente);

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
