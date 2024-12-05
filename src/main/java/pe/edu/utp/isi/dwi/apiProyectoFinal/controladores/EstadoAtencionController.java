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
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.EstadoAtencion;
import pe.edu.utp.isi.dwi.apiProyectoFinal.servicios.EstadoAtencionServicio;

@RestController
@RequestMapping("/estadoAtencion")
public class EstadoAtencionController {
    
    @Autowired
    private EstadoAtencionServicio estadoAtencionServicio;
    
    @GetMapping("/listar")
    public List<EstadoAtencion> listarEstadoAtencion() {
        return estadoAtencionServicio.listarEstadosAtencion();
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<EstadoAtencion> registrarEstadoAtencion(@Valid @RequestBody EstadoAtencion estadoAtencion) {
        EstadoAtencion estadoAtencionGuardada = estadoAtencionServicio.registrarEstadoAtencion(estadoAtencion);
        return new ResponseEntity<>(estadoAtencionGuardada, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarEstadoAtencion(@PathVariable int id) {
        EstadoAtencion estadoAtencionGuardada = estadoAtencionServicio.consultarEstadoAtencion(id);
        
        if(estadoAtencionGuardada != null) {
            estadoAtencionServicio.eliminarEstadoAtencion(estadoAtencionGuardada);
        }
    }    
}
