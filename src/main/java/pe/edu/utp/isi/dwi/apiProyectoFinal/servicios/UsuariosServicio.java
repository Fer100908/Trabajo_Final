package pe.edu.utp.isi.dwi.apiProyectoFinal.servicios;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.Usuarios;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.RolUsuario;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.TipoDocumento;
import pe.edu.utp.isi.dwi.apiProyectoFinal.modelo.Especialidad;
import pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio.RolUsuarioRepositorio;
import pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio.TipoDocumentoRepositorio;
import pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio.EspecialidadRepositorio;
import pe.edu.utp.isi.dwi.apiProyectoFinal.repositorio.UsuariosRepositorio;

@Service
public class UsuariosServicio {
    
    @Autowired
    private UsuariosRepositorio usuariosRepositorio;      
    
    @Autowired
    private TipoDocumentoRepositorio tipoDocumentoRepositorio;     
    
    @Autowired
    private RolUsuarioRepositorio rolUsuarioRepositorio;     
    
    @Autowired
    private EspecialidadRepositorio especialidadRepositorio;
    
    public List<Usuarios> listarUsuarios() {
        return usuariosRepositorio.findAll();
    }
    
    public Usuarios consultarUsuarios(long id) {
        return usuariosRepositorio.findById(id).get();
    }

    public Usuarios registrarUsuarios(Usuarios usuarios) {
        return usuariosRepositorio.save(usuarios);
    }
    
    @Transactional
    public Usuarios registrarUsuario(Usuarios usuario, int idRolUsuario, int idTipoEspecialidad, int idTipoDocumento) {
        RolUsuario rolTemp = rolUsuarioRepositorio.getById((long)idRolUsuario);
        TipoDocumento tipoDocumentoTemp = tipoDocumentoRepositorio.getById((long)idTipoDocumento);
        Especialidad especialidadTemp = especialidadRepositorio.getById((long)idTipoEspecialidad);

        usuario.setRolUsuario(rolTemp);
        usuario.setTipoEspecialidad(especialidadTemp);
        usuario.setTipoDocumento(tipoDocumentoTemp);

        // Guardar la persona
        return usuariosRepositorio.save(usuario);
    }
    
    public void eliminarUsuarios(Usuarios usuarios) {
        usuariosRepositorio.delete(usuarios);
    }    
}
