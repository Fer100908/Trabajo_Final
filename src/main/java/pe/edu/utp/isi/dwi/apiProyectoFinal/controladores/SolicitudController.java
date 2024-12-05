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
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.Solicitud;
import pe.edu.utp.isi.dwi.apiProyectoFinal.servicios.SolicitudServicio;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {
    
    @Autowired
    private SolicitudServicio solicitudServicio;
    
    @GetMapping("/listar")
    public List<Solicitud> listarSolicitudes() {
        return solicitudServicio.listarSolicitudes();
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<Solicitud> registrarSolicitud(@Valid @RequestBody Solicitud solicitud) {
        Solicitud solicitudGuardada = solicitudServicio.registrarSolicitud(solicitud);
        return new ResponseEntity<>(solicitudGuardada, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarSolicitud(@PathVariable int id) {
        Solicitud solicitudGuardada = solicitudServicio.consultarSolicitud(id);
        
        if(solicitudGuardada != null) {
            solicitudServicio.eliminarSolicitud(solicitudGuardada);
        }
    }    
}
