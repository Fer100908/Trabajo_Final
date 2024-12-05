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
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.RolUsuario;
import pe.edu.utp.isi.dwi.apiProyectoFinal.servicios.RolUsuarioServicio;

@RestController
@RequestMapping("/rolUsuario")
public class RolUsuarioController {
    
    @Autowired
    private RolUsuarioServicio rolUsuarioServicio;
    
    @GetMapping("/listar")
    public List<RolUsuario> listarRolUsuario() {
        return rolUsuarioServicio.listarRolUsuario();
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<RolUsuario> registrarRolUsuario(@Valid @RequestBody RolUsuario rolUsuario) {
        RolUsuario rolUsuarioGuardado = rolUsuarioServicio.registrarRol(rolUsuario);
        return new ResponseEntity<>(rolUsuarioGuardado, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarRolUsuario(@PathVariable int id) {
        RolUsuario rolUsuarioGuardado = rolUsuarioServicio.consultarRoles(id);
        
        if(rolUsuarioGuardado != null) {
            rolUsuarioServicio.eliminarRol(rolUsuarioGuardado);
        }
    }    
}
