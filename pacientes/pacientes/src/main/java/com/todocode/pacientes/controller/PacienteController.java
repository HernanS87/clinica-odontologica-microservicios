package com.todocode.pacientes.controller;

import com.todocode.pacientes.model.Paciente;
import com.todocode.pacientes.service.IPacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {
   
   @Autowired
   IPacienteService pacienteService;
   
   @GetMapping
    public String inicio () {
        return "Microservicio Pacienteeeeeees!!!!!!";
    }
   
   //1- crear un nuevo paciente
   @PostMapping ("/pacientes/crear")
   public String crearPaciente (@RequestBody Paciente pac) {
           pacienteService.savePaciente(pac);

           return "El paciente fue creado correctamente";
   }   

   //2- traer todos los pacientes
   @GetMapping ("/pacientes/traer")
   public List<Paciente> traerPacientes () {
       return pacienteService.getPacientes();
   }
   //3- Eliminar un paciente
   @DeleteMapping("/pacientes/borrar/{id}")
   public String deletePaciente(@PathVariable Long id) {
       pacienteService.deletePaciente(id);

       return "El paciente fue eliminado correctamente";
   }

   //4- Editar un paciente
   @PutMapping ("/pacientes/editar/{id_original}")
   public Paciente editPaciente (@PathVariable Long id_original,
                                @RequestBody Paciente pacienteEditar) {

      pacienteService.editPaciente(id_original, pacienteEditar);
      Paciente pacienteEditado = pacienteService.findPaciente(id_original);

      return pacienteEditado;

   }

  //5- obtener un paciente en particular 
    @GetMapping ("/pacientes/traer/{id}")
   public Paciente traerPaciente (@PathVariable Long id) {
       return pacienteService.findPaciente(id);
   }
   
}
