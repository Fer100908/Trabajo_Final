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
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.Asignacion;
import pe.edu.utp.isi.dwi.apiProyectoFinal.servicios.AsignacionServicio;

@RestController
@RequestMapping("/asignacion")
public class AsignacionController {
    
    @Autowired
    private AsignacionServicio asignacionServicio;
    
    @GetMapping("/listar")
    public List<Asignacion> listarAsignaciones() {
        return asignacionServicio.listarAsignaciones();
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<Asignacion> registrarAsignaciones(@Valid @RequestBody Asignacion asignacion) {
        // Aquí se puede hacer la validación de que el ticket asociado existe antes de registrarlo
        Asignacion asignacionGuardada = asignacionServicio.registrarAsignacion(asignacion);
        return new ResponseEntity<>(asignacionGuardada, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarAsignaciones(@PathVariable int id) {
        Asignacion asignacionGuardada = asignacionServicio.consultarAsignacion(id);
        
        if(asignacionGuardada != null) {
            asignacionServicio.eliminarAsignacion(asignacionGuardada);
        }
    }    
}
