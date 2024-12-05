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
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.RegistroPersonaRequest;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.Usuarios;
import pe.edu.utp.isi.dwi.apiProyectoFinal.servicios.UsuariosServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    
    private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);
    
    @Autowired
    private UsuariosServicio usuariosServicio;
    
    @GetMapping("/listar")
    public List<Usuarios> listarUsuarios() {
        return usuariosServicio.listarUsuarios();
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<Usuarios> registrarUsuario(@Valid @RequestBody RegistroPersonaRequest registroPersonaRequest) {
        try {
            // Imprimir un mensaje de prueba
            logger.info("Iniciando el registro de una nueva persona.");
            
            logger.info("Datos del Usuario: {}", registroPersonaRequest.getUsuario());

            int idRolUsuario = registroPersonaRequest.getIdRolUsuario();
            int idTipoEspecialidad = registroPersonaRequest.getIdTipoEspecialidad();
            int idTipoDocumento = registroPersonaRequest.getIdTipoDocumento();
            
            
            Usuarios usuarioGuardado = usuariosServicio.registrarUsuario(
                registroPersonaRequest.getUsuario(),idRolUsuario,idTipoEspecialidad,idTipoDocumento
            );

            return new ResponseEntity<>(usuarioGuardado, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Log de error
            logger.error("Error durante el registro: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        Usuarios usuarioGuardado = usuariosServicio.consultarUsuarios(id);
        
        if(usuarioGuardado != null) {
            usuariosServicio.eliminarUsuarios(usuarioGuardado);
        }
    }    
}
