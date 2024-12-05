package pe.edu.utp.isi.dwi.apiProyectoFinal.controladores;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.Especialidad;
import pe.edu.utp.isi.dwi.apiProyectoFinal.servicios.EspecialidadServicio;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {
    
    @Autowired
    private EspecialidadServicio especialidadServicio;
    
    @GetMapping("/listar")
    public List<Especialidad> listarEspecialidades() {
        return especialidadServicio.listarEspecialidades();
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<Especialidad> registrarEspecialidad(@Valid @RequestBody Especialidad especialidad) {
        Especialidad especialidadGuardada = especialidadServicio.registrarEspecialidad(especialidad);
        return new ResponseEntity<>(especialidadGuardada, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarEspecialidad(@PathVariable int id) {
        Especialidad personaGuardada = especialidadServicio.consultarEspecialidades(id);
        
        if(personaGuardada != null) {
            especialidadServicio.eliminarEspecialidad(personaGuardada);
        }
    }
}
